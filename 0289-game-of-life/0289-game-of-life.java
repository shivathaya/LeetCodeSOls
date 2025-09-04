class Solution {
    // truth table --> this is for inmemory utilization here we use custom truth table
    //o     n       tv
    //0     0       0
    //1     0       1
    //0     1       2
    //1     1       3
    public void gameOfLife(int[][] board) {

        int row = board.length;
        int col = board[0].length;
        // find the neighbour
        // loop through each cell
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                // get live neighbourd
                int neig = liveNeighbour(r,c, board);
                //if cell is 1 and and live neighbour is 2 or 3 then cell cont to leave so cell = 3
                if(board[r][c]==1){
                    if(neig == 2 || neig == 3)
                        board[r][c] = 3;
                }
                // if cell is dead and it has 3 live neighbour then cell will be live
                else if(neig == 3)
                    board[r][c] = 2;
            }
        }
        // now replace the board with only 0 and 1s
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(board[r][c] == 2 || board[r][c] == 3)
                    board[r][c] = 1;
                else 
                    board[r][c] = 0;
            }
        }
    }

    // helper func to find live neighbours
    public int liveNeighbour(int r, int c, int[][] board){
        int nei = 0;
        for(int i=r-1; i<r+2; i++){
            for(int j=c-1; j<c+2; j++){
                // handling array out of bounds exception
                if((i==r && j==c) || i<0 || j<0 || i>= board.length || j>=board[0].length)
                    continue;
                //if live neighbour found increment neighbour
                if(board[i][j] ==1 || board[i][j]==3)
                    nei += 1;

            }
        }
        return nei;
    }
}