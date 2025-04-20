class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i: nums){
            if(i<= first){
                first = i;
               // second = Integer.MAX_VALUE;
            } else if(i<=second){
                second = i;
            } else if(i>second){
                return true;
            }
        }
        return false;

    }
}