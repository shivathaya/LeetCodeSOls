class Solution {
    public int largestAltitude(int[] gain) {
        int curAlt = 0, maxAlt = 0;

        for (int i : gain) {
            curAlt += i;
            maxAlt = Math.max(maxAlt, curAlt);
        }
        return maxAlt;
    }
}