class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> mag = new HashMap<>();

        for(char c: magazine.toCharArray()){
            mag.put(c, mag.getOrDefault(c,0)+1);
        }

        for(char s: ransomNote.toCharArray()){
            if(mag.containsKey(s) && mag.get(s)>0){
                mag.put(s,mag.get(s)-1);
            }else return false;
        }

    return true;
    }
}