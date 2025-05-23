class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n= board[0].length;
        boolean [][] visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j< n; j++){
               if(dfs(board, word, i, j, 0, visited))
                return true;
            }
        }

        return false;

    }

    public boolean dfs(char[][]board, String word, int r, int c, int count, boolean[][] visited){
        if(count == word.length())
            return true;

        if(r>=0 && c>=0 && r< board.length && c<board[0].length && board[r][c] == word.charAt(count) && !visited[r][c]){
            
            visited[r][c] = true;

            if(dfs(board, word, r+1, c, count+1, visited) ||
            dfs(board, word, r-1, c, count+1, visited) ||
            dfs(board, word, r, c+1, count+1, visited) ||
            dfs(board, word, r, c-1, count+1, visited)){
                return true;
            }
            visited[r][c] = false;
        }

        
        return false;



    
    }
}