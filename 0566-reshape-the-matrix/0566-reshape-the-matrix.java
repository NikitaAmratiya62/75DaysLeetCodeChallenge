class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!=r*c) return mat;
        int[][] arr=new int[r][c];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int index = i * mat[0].length + j;
                arr[index / c][index % c] = mat[i][j];
            }
        }
        return arr;
    }
}