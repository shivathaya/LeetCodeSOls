class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i < nums.length){
            //String s = String.valueOf(i);
            int j =i+1;
            int curr = nums[i];
            while(j<nums.length && nums[j] == curr+1){
                curr = nums[j];
                j++;
                
            }
            if(j-1>i)
                ans.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j-1]));
            else
                ans.add(String.valueOf(nums[i]));
            i = j;
        }
        return ans;
    }
}