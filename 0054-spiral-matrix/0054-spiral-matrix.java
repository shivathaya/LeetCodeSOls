class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length;

        int top = 0;
        int btm = matrix.length;
        List<Integer> output = new ArrayList<>(); 

        while(left< right && top<btm){
            for(int i= left; i< right; i++)
                output.add(matrix[top][i]);
            top +=1;
            for(int i= top; i<btm; i++)
                output.add(matrix[i][right-1]);
            right -=1;
            if(left>= right || top>=btm)
                break;
            for(int i=right-1; i>=left; i--)
                output.add(matrix[btm-1][i]);
            btm -=1;

            for(int i=btm-1; i>=top; i--)
                output.add(matrix[i][left]);
            left +=1;

        }
        return output;

    }
}