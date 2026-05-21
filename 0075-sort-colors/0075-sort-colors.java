class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int mid = 0;
        int last = nums.length -1;

        while(mid <= last){
           // System.out.println(nums[mid]);
            if(nums[mid] == 0){
                //swap start and mid
                int temp = nums[start];
                nums[start] = nums[mid];
                nums[mid] = temp;
                // System.out.println(nums[start]+","+nums[mid]);
                start++;
                mid++;
            }

            else if(nums[mid] == 2){
                int temp = nums[last];
                nums[last] = nums[mid];
                nums[mid] = temp;
               // System.out.println(nums[mid]+","+nums[last]);
               // mid++;
                last--;
            }

            else{
                mid++;
            }
        }
    }


}