class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> currList = new ArrayList<>();
        this.nums = nums;

        backTrack(currList, 0);

        return result;
        
    }

    private void backTrack(List<Integer> currList, int idx){
        if(idx == nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }

        currList.add(nums[idx]);
        backTrack(currList, idx+1);
        currList.remove(currList.size() -1);
        backTrack(currList, idx+1);
    }


}