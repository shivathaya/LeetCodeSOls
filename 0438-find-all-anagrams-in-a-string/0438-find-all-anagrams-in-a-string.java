class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pf = new int[26];
        int[] wf = new int[26];
        int wSize = p.length();

        for(char c: p.toCharArray())
            pf[c-'a']++;

        for(int i=0; i< s.length(); i++){
            wf[s.charAt(i) - 'a']++;

            if(i >= wSize){
                wf[s.charAt(i-wSize) - 'a']--;

            }

            if(Arrays.equals(pf, wf)){
                res.add(i-wSize+1);
            }
        }
        return res;

        // List<Integer> res = new ArrayList<>();
        // int k = p.length();
        // char[] parr =  p.toCharArray();
        // Arrays.sort(parr);

        // for(int i=0; i< s.length()-k+1; i++)
        // {
        //     String subs = s.substring(i, i+k);
        //     System.out.println(subs);
        //     char[] suba = subs.toCharArray();
        //     Arrays.sort(suba);

        //     if(Arrays.equals(parr, suba)){
        //         res.add(i);
        //     }

        // } 
        // return res;
    }
}
