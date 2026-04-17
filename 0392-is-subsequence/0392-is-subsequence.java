class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length())
            return false;
        if(s.isEmpty())
            return true;
        int sp = 0;
        for(char c: t.toCharArray()){
            if(s.charAt(sp) == c)
                sp++;
            if(sp == s.length())
                return true;
        }

        return false;
        
    }
}