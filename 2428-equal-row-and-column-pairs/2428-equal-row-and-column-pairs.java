class Solution {
    public int equalPairs(int[][] grid) {
        String rls = "";
        String clos = "";
        int count = 0;
        HashMap<String, Integer> hsmp = new HashMap<>();

        //List<String> cls = new ArrayList<>();
        String rl = "";
        for(int i =0; i< grid.length; i++){
            rls = Arrays.toString(grid[i]);
            hsmp.put(rls, hsmp.getOrDefault(rls,0)+1);

        }
        int[] cls = new int[grid.length];
        for(int i =0; i<grid.length; i++){
            for(int j =0; j< grid.length; j++){
                cls[j] = grid[j][i]; 
            }
            clos = Arrays.toString(cls);
            count += hsmp.getOrDefault(clos,0);
        }

        return count;
    }
}