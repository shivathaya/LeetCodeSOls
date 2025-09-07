class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] wrdList = s.split(" ");
        if(pattern.length() != wrdList.length) return false;

        Map<Character, String> mapCh = new HashMap<>();

        for(int i=0; i< pattern.length(); i++){
            char c = pattern.charAt(i);
            if(mapCh.containsKey(c)){
                if(!mapCh.get(c).equals(wrdList[i]))
                    return false;

            }else if(!mapCh.values().contains(wrdList[i])){
                mapCh.put(c, wrdList[i]);
            }else
                return false;
        }
        return true;
    }
}