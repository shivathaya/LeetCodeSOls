class Solution {
    public int characterReplacement(String s, int k) {
       
           int[] freq = new int[26]; // frequency of characters
    int left = 0;
    int maxFreq = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
        // update frequency of current char
        freq[s.charAt(right) - 'A']++;

        // track max frequency in current window
        maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

        // check if window is valid
        int windowSize = right - left + 1;
        if (windowSize - maxFreq > k) {
            // shrink window
            freq[s.charAt(left) - 'A']--;
            left++;
        }

        // update answer
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
    }
}