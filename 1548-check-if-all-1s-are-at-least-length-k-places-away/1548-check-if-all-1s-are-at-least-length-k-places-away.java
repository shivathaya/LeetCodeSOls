class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int cnt = 0;
        boolean oneFnd = false;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 1 ){
                if(cnt < k && i !=0 && oneFnd) return false; 
                cnt = 0;
                oneFnd = true;
            }else{
                cnt++;
            }
        }

        return true;
    }
}