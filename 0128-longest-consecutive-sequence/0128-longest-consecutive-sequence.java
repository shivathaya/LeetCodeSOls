class Solution {
    public int longestConsecutive(int[] nums) {
        //Approach using SEt 

/*        Set<Integer> numSet = new HashSet<>();
        for(int n: nums){
            numSet.add(n);
        }
        int cnt = 0;

        for(int n: nums){
            int c = 1;
            int nxt = n+1;
            while(numSet.contains(nxt)){
                c++;
                nxt++;
            }
            cnt = Math.max(cnt,c);
        }
        return cnt;
    }*/


        Map<Integer, Boolean> map = new HashMap<>();
        int max=0;
        for(int i: nums)
            map.put(i, Boolean.FALSE);
        for(int i: nums){
            int curlen = 1;
            int next = i+1;
            while(map.containsKey(next) && map.get(next)==false){
               curlen ++;
                map.put(next, Boolean.TRUE);
                next++;
            }
            int prev = i-1;
            while(map.containsKey(prev) && map.get(prev)==false){
                curlen ++;
                map.put(prev, Boolean.TRUE);
                prev--;
           }

            max = Math.max(max, curlen);
        }
        return max;
    }
}

