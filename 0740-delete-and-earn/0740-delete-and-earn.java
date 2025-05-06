class Solution {
    public int deleteAndEarn(int[] nums) {
         int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // frequency 
        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }

        int take = 0, skip = 0;
        for (int i = 0; i <= max; i++) {
            int take_i = skip + points[i]; // Take current: add points[i], skip previous
            int skip_i = Math.max(skip, take); // Skip current: max of previous take or skip
            take = take_i;
            skip = skip_i;
        }

        return Math.max(take, skip);
    }
}