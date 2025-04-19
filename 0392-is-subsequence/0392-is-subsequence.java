class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        if(s.length() == 0) 
            return true;
        if(t.length() ==0 || s.length()>t.length())
            return false;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;  
            if(i == s.length()){
            return true;
        }else if(j == t.length())
            return false;
        }
        return false;
    }
}