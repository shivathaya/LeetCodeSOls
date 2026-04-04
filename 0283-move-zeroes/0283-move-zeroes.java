class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;

        for(int num : nums){
            if(num != 0){
                nums[l] = num;
                l++;
            }
        }

        while(l<nums.length){
            nums[l] = 0;
            l++;
        }
    }
}