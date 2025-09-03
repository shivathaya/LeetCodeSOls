class Solution {
    // created this record for the the key of hash mao x,y rep each sub 3x3 box
    public record Pair(int x, int y) {};
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> rowS = new HashMap<>();// seen in row
        Map<Integer, Set<Character>> colS = new HashMap<>();//seen in col
        Map<Pair, Set<Character>> squr = new HashMap<>();//seen in 3x3 box
        // always till 9 bec max size is 9
        for(int r = 0; r< 9; r++){
            for(int c = 0; c< 9; c++){
                //. means not filled so skip it 
                if(board[r][c] == '.') continue;
                //if set not there for row r means create new row
                //check if the num laready in that row-> means duplicate -> invalid
                // else add the num to row set
                // do same for column and 3x3 square
                if (rowS.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])) return false;
                rowS.get(r).add(board[r][c]);
                if (colS.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])) return false;
                colS.get(c).add(board[r][c]);
                Pair sqk = new Pair(r/3, c/3);
                if (squr.computeIfAbsent(sqk, k -> new HashSet<>()).contains(board[r][c])) return false;
                squr.get(sqk).add(board[r][c]);

            }
        }
        return true;
    }
}