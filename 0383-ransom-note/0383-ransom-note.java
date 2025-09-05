class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> mag = new HashMap<>();
        //add magazine in hashmap with count
        for(char c: magazine.toCharArray()){
            mag.put(c, mag.getOrDefault(c,0)+1);
        }
        //if char of s in map nad count more than 0
        for(char s: ransomNote.toCharArray()){
            if(mag.containsKey(s) && mag.get(s)>0){
                //continue and decrement count
                mag.put(s,mag.get(s)-1);
            }else return false;
        }

    return true;
    }
}