class Solution {
    public String minWindow(String s, String t) {
        /* ... use 2 hash map <char count of occurance> one for window have and one for T- how many we need . 
        compare have with need and relation is >=. do this for all elements in array
        if it is not >= then increase the window 
        if all have >= need then res = window size 
         */
        if (t == "" || s.length() < t.length()) return "";
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needT = new HashMap<>();

        for(char c : t.toCharArray()){
            needT.put(c, needT.getOrDefault(c,0)+1);
        }

        // we will check if have>= need
        int have = 0;
        int need = needT.size();
        int r=0, l=0;
        int start=0, minL = Integer.MAX_VALUE;
        while(r < s.length()){
            char c = s.charAt(r);
            r++;
            if(needT.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);

                if(needT.get(c).intValue() == window.get(c).intValue())
                    have +=1;
            }
            //update the result length
            while(have == need){
                if(r-l < minL){
                    // store start and minlen for resulr substring --> [start, start+minLen]
                    start = l;
                    minL = r-l;
                }
                // shorten window - so need char of left to to update the hashmap window as chatof value -1
                char lft = s.charAt(l);
                l++;
                // do -ve if the valid char is removed from left
                if(needT.containsKey(lft)){
                    if(needT.get(lft).intValue() == window.get(lft).intValue())
                        have -=1;
                    window.put(lft,window.getOrDefault(lft,0)-1);
                }

            }
        }
        return (minL == Integer.MAX_VALUE)?"": s.substring(start, start+minL);

    }
}