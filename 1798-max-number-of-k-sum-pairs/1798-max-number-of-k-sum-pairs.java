class Solution {
    public int maxOperations(int[] nums, int k) {
       int i=0;
       Arrays.sort(nums);
       int j=nums.length -1;
       //List<Integer> nums1 = (Integer) Arrays.asList(nums);
       int sum = 0;
       int op = 0;
       while(i<j){
        sum = nums[i] + nums[j];
        if(sum == k){
            op++;
            i++;
            j--;
        }
        else if(sum > k) j--;
        else if(sum < k) i++;
       
       } 
    return op;
    }
}