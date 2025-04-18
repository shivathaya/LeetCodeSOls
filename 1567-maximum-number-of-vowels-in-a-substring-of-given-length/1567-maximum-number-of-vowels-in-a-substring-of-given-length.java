class Solution {
    public int maxVowels(String s, int k) {
        int maxv = 0;
        int cnt = 0;
        Set<Character> vwls = Set.of('a', 'e', 'i', 'o','u');

        for(int i=0; i<k; i++){
            if(vwls.contains(s.charAt(i))) 
                cnt++;
        }

        maxv = cnt;
        for(int i=k; i< s.length(); i++){
            if(vwls.contains(s.charAt(i-k)))
                cnt--;
            if(vwls.contains(s.charAt(i)))
                cnt++;
            maxv= Math.max(maxv,cnt);
        }

        return maxv;
    }
}