class Solution {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix[0].length-1;


        while(l<r){
            int t = l;
            int b = r;
            for(int i =0; i< r-l; i++){
                int tmp = matrix[t][l+i];

                matrix[t][l+i] = matrix[b-i][l];
                matrix[b-i][l] = matrix[b][r-i];
                matrix[b][r-i] = matrix[t+i][r];
                matrix[t+i][r] = tmp;
            }
            l +=1;
            r -=1;
        }
    }
}
