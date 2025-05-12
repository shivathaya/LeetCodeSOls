class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mtx = new int[m][n];

        for(int i=0; i<m; i++) mtx[i][0] = 1;
        for(int j=0; j<n; j++) mtx[0][j] = 1;

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                mtx[i][j] = mtx[i-1][j] + mtx[i][j-1];
            }
        }

        return mtx[m-1][n-1];
    }
}