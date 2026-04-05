class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int r = 0;
        for(int i=0; i<n; i++){
            res[r++] = nums[i];
            res[r++] = nums[i+n];
            //r++;
        }

        return res;
    }
}