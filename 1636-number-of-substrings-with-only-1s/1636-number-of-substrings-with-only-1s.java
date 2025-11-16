class Solution {
    public int numSub(String s) {
        long ans = 0;
        long curr = 0;
        long mod = 1_000_000_007;
        for(char c: s.toCharArray()){
            if(c == '1') curr++;
            else{
                ans = (ans+(curr* (curr+1))/2)%mod;
                curr = 0;
            }
        }
        ans = (ans+(curr* (curr+1))/2)%mod;
        curr = 0;
        return (int) ans;
    }
}