class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int left =0, right = 0, maxLen = 0;

        while(right<s.length()){
            char curr = s.charAt(right);

            while(seen.contains(curr)){
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(curr);
            maxLen = Math.max(maxLen, right-left+1);
            right++;

        }

        return maxLen;
    }
}