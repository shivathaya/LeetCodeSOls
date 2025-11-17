class Solution {
    public int findDuplicate(int[] nums) {
        // linked list problem arr index as node and val as pointer
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int slow2 = 0;
        while(slow2 != slow){
            slow= nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}