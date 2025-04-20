class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowls = new HashSet<>();
        String vwls = "aeiouAEIOU";
        
        char[] str = s.toCharArray();
        for (char c : vwls.toCharArray())
            vowls.add(c);
        int left = 0;
        int right = str.length - 1;

        while (left < right) {
            while (left<right && !vowls.contains(str[left]))
                left++;
            while (left<right && !vowls.contains(str[right]))
                right--;

            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }

        return String.valueOf(str);
    }
}