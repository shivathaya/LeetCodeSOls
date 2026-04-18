class Solution {
    List<List<Integer>> result  = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        this.nums = nums;

        backtrack(path);

        return result;
        
    }

    private void backtrack(List<Integer> path){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(Integer num: nums){
            if(path.contains(num)){
                continue;
            }

            path.add(num);
            backtrack(path);
            path.remove(path.size()-1);
        }
    }
}