class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i =0; i< numRows; i++){
            List<Integer> r = new ArrayList<>();

            for(int j = 0; j<= i; j++){
                if(j == 0 || j == i)
                    r.add(1);
                else{
                    List<Integer> prevRow = res.get(i-1);

                    r.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }
            res.add(r);
        }

        return res;
    }
}