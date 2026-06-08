class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans=new ArrayList<>();
        int m=matrix.length,n=matrix[0].length;
        int fr=0,fc=0,lr=m-1,lc=n-1;
        int tne=m*n;
        while(ans.size()<tne){
            for(int j=fc;j<=lc;j++){
                ans.add(matrix[fr][j]);
            }
            fr++;
            if(ans.size()==tne) break;
            for(int i=fr;i<=lr;i++){
                ans.add(matrix[i][lc]);
            }
            lc--;
            if(ans.size()==tne) break;
            for(int j=lc;j>=fc;j--){
                ans.add(matrix[lr][j]);
            }
            lr--;
            if(ans.size()==tne) break;
            for(int i=lr;i>=fr;i--){
                ans.add(matrix[i][fc]);
            }
            fc++;
        }
        return ans;
        
    }
}