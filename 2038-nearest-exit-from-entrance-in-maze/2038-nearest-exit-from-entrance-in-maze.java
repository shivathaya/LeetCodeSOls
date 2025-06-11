class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;

        int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int stp = curr[2];
            for(int[] dir: direction){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && maze[nr][nc] =='.'){
                    if(nr == 0 || nr == m-1 || nc == 0 || nc == n-1) {
                        return stp + 1;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc,stp+1});
                }
            }

        }
        return -1;
    }
}