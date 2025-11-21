class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        // Initialize first occurrence to large and last to small
        for (int i = 0; i < 26; i++) {
            first[i] = n;
            last[i] = -1;
        }

        // Track first and last index of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = Math.max(last[c], i);
        }

        int res = 0;

        // For each char, count distinct chars in between first & last
        for (int ch = 0; ch < 26; ch++) {
            if (first[ch] < last[ch]) {
                boolean[] seen = new boolean[26];
                for (int i = first[ch] + 1; i < last[ch]; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                for (boolean b : seen) {
                    if (b) res++;
                }
            }
        }

        return res;
    }
}