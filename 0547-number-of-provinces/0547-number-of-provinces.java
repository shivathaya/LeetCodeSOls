class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;

        boolean[] visited = new boolean[len];
        int count = 0;

        for(int i =0; i< len; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int c, int[][] isConnected, boolean[] visited){
        visited[c] = true;

        for(int j = 0; j< isConnected.length; j++){
            if(isConnected[c][j] == 1 && !visited[j]){
                dfs(j, isConnected, visited);
            }
        }
    }
}