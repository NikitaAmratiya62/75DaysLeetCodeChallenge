class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int srt=0,end=matrix[0].length-1;
            while(srt<end){
                int temp=matrix[i][srt];
                matrix[i][srt]=matrix[i][end];
                matrix[i][end]=temp;
                srt++;
                end--;
            }


        }
    }
}