class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int req = target- nums[i];

            if(numMap.containsKey(req)){
                return new int[]{numMap.get(req), i};
            }

        numMap.put(nums[i], i);
        }

        return new int[]{};
    }
}