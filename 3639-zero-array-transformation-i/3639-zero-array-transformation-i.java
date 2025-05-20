class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n+1];
        
        for(int[] query: queries){
            int l = query[0];
            int r = query[1];
//diff array used
            diff[l] += 1;
            if(r+1 <n)
                diff[r+1] -=1;
        }
// prefix sum use 
        int[] ops = new int[n];
        ops[0] = diff[0];

        for(int i =1; i<n; i++){
            ops[i] = ops[i-1] + diff[i];
        }


        for(int i =0; i<n; i++){
            if(nums[i] > ops[i])
                return false;
        }
        return true;
    }
}