class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // we find caclSubArrays of k - caclSubArrays of k-1 = sub array with k dist ele
        return caclSubArrays(nums, k) - caclSubArrays(nums, k-1);
    }

    private int caclSubArrays(int[] nums, int k){ // calc subarray that is <=k

        int l = 0, r = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(r < nums.length){
            // put ele to map with freq -> map of distinct eles
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            // if map size > k then more that k distinct ele so reduse window

            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) -1);
                if(map.get(nums[l]) <= 0){
                    map.remove(nums[l]);
                }
                l++;
            }

            cnt = cnt+r-l+1;
            r++;

        }
        //System.out.println(cnt);
        return cnt;
    }
}