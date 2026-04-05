class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCnt = 0;
        int cnt = 0;
        for(int i: nums){
            cnt++;
            if(i == 0){
                cnt = 0;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}