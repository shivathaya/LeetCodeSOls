class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                cleaned.append(Character.toLowerCase(c));
        }
        int l = 0;
        int r = cleaned.length() -1;
        while(l<r){
            if(cleaned.charAt(l) != cleaned.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}