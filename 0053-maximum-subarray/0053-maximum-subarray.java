class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];


        // at every pos need to see if i need to include ( if sum increasing) the current sum in subarray sum or start new
        for(int i=1; i<nums.length; i++){

            currSum = Math.max(currSum ,0) + nums[i];
            
            maxSum = Math.max(maxSum, currSum);


        }

        return maxSum;
    }
}