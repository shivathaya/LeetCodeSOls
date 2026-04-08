class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        for(int[] intrvl : intervals){
            if(res.isEmpty() || res.get(res.size() -1)[1] < intrvl[0]){
            
                res.add(intrvl);
            }
            else{
                res.get(res.size() -1)[1] =  Math.max(res.get(res.size() -1)[1], intrvl[1]); 
            }
            
        }

        return res.toArray(new int[res.size()][]);
    }
}