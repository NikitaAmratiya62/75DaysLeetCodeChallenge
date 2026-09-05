class Solution {
    static int[] dp;
    public int tribonacci(int n) {
        dp=new int[n+1];
        return tribo(n);
    }
    public int tribo(int n){
        if(n<=1) return n;
        if(n==2) return 1; 
        if(dp[n]!=0) return dp[n];
        int ans=tribo(n-1)+ tribo(n-2)+ tribo(n-3);
        dp[n]=ans;
        return ans;
    }
}