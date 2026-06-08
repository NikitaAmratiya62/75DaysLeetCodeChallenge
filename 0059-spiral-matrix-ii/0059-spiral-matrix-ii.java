class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int fr=0,fc=0,lr=n-1,lc=n-1;
        int count=1;
        while( fr<=lr && fc<=lc){
            for(int j=fc;j<=lc;j++){
                ans[fr][j]=count;
                count++;
            }
            fr++;
            if( fr>lr || fc>lc) break;
            for(int i=fr;i<=lr;i++){
                ans[i][lc]=count;
                count++;
            }
            lc--;
            if( fr>lr || fc>lc ) break;
            for(int j=lc;j>=fc;j--){
                ans[lr][j]=count;
                count++;
            }
            lr--;
            if( fr>lr || fc>lc) break;
            for(int i=lr;i>=fr;i--){
                ans[i][fc]=count;
                count++;
            }
            fc++;
        }
        return ans;
        
    }
}