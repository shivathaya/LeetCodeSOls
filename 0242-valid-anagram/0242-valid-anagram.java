class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> cnt = new HashMap<>();

        for(char c: s.toCharArray()){
            cnt.put(c, cnt.getOrDefault(c,0)+1);
        }

        for(char c: t.toCharArray()){
            if(!cnt.containsKey(c)) return false;

            cnt.put(c,cnt.get(c)-1);

            if(cnt.get(c) == 0)
                cnt.remove(c);
        }

        return cnt.isEmpty();



    }
}