class Solution {
    public boolean isPalindrome(int x) {
        int n = x;
        int revNum = 0;
        while(n != 0){
            int r = n%10;
            n = n/10;
            revNum = revNum *10 + r;
        }

        if(x == revNum && x>=0){
            return true;
        }

        return false;


    }
}