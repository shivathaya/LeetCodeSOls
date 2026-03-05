class Solution {
    public int longestOnes(int[] nums, int k) {
       int maxCnt =0;
        int cnt = 0;
        int l = 0;
       for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0){
                cnt ++;
            }
                while(cnt > k){
                    if(nums[l] == 0)
                        cnt --;
                    l++;
                }
            maxCnt = Math.max(maxCnt, i-l+1);
       } 

       return maxCnt;
    }
}