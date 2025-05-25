class Solution {
    public int longestPalindrome(String[] words) {
                Map<String, Integer> freqMap = new HashMap<>();
        
   
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        int length = 0;
        boolean hasMiddle = false;

        for (String word : freqMap.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (word.equals(reversed)) {
                int count = freqMap.get(word);
                length += (count / 2) * 4;
                if (count % 2 == 1) {
                    hasMiddle = true;
                }
            } else if (word.compareTo(reversed) < 0 && freqMap.containsKey(reversed)) {
                int count = freqMap.get(word);
                int reverseCount = freqMap.get(reversed);
                int pairCount = Math.min(count, reverseCount);
                length += pairCount * 4;
            }
        }

        if (hasMiddle) {
            length += 2;
        }

        return length;
    }
}