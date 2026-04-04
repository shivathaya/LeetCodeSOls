class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int l = 0;
        int r = nums.length -1;
        int[] op = new int[nums.length];
        int p = nums.length -1;
        while(l<=r){
            
            int ls = nums[l]*nums[l];
            int rs = nums[r]*nums[r];
           // System.out.println(ls);System.out.println(rs);
            if(ls > rs){
                op[p] = ls;
                l++;
            } else{
                op[p] = rs;
                r--;
            }
            p--;
        }

        return op;
    }
}