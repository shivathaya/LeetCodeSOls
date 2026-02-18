class Solution {
    public int[] countBits(int n) {
        int[] opArr = new int[n+1];
            //StringBuffer sb = "";
        for(int i=0; i<= n; i++){
            opArr[i] = Integer.bitCount(i);

        }
        return opArr;
    }
}