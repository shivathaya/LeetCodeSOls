class Solution {
    public int climbStairs(int n) {
        if(n<= 2) return n;

        int nMin1 = 2;
        int nMin2 = 1;

        for(int i = 3; i<=n; i++){
            int cur = nMin1 + nMin2;
            nMin2 = nMin1;
            nMin1 = cur;
        }

        return nMin1;
    }
}