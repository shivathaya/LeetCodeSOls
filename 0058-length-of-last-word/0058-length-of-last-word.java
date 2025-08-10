class Solution {
    public int lengthOfLastWord(String s) {
        String[] wrd = s.trim().split("\\s+");
       // System.out.println(Arrays.toString(wrd));
        String last = wrd[wrd.length -1];
       // System.out.println(last);
        return last.length();

    }
}