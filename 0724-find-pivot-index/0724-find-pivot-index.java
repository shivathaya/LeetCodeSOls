class Solution {
    public int pivotIndex(int[] nums) {
        int lsum = 0;
        int rsum = 0;
        int sum = 0;
        for(int i: nums)
            sum += i;
        
        for(int i=0; i<nums.length; i++){

            rsum = sum - lsum - nums[i];

            if(lsum == rsum){
                return i;
            }
            lsum += nums[i];

        }
        return -1;
    }
}