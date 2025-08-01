class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int res = 0;
        int n = nums.length;

        while (r < n - 1) {
            int farthest = 0;

            for (int i = l; i < r+1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }

}