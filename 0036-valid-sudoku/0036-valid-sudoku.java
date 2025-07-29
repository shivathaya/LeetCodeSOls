class Solution {
    public record Pair(int x, int y) {};
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> rowS = new HashMap<>();
        Map<Integer, Set<Character>> colS = new HashMap<>();
        Map<Pair, Set<Character>> squr = new HashMap<>();

        for(int r = 0; r< 9; r++){
            for(int c = 0; c< 9; c++){
                if(board[r][c] == '.') continue;

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