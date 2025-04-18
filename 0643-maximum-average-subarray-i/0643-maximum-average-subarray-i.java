class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        double sum =0;
        for(i =0; i<k; i++){
            sum += nums[i]; 
        }

        double maxSum  = sum;

        for(i = k; i< nums.length; i++){
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum/k;
    }
}