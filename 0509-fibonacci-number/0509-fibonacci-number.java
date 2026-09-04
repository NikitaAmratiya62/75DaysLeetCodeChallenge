class Solution {
    static int[] dp;
    public int fib(int n) {
        dp=new int[n+1];
        return fibnum(n);
    }
    public int fibnum(int n){
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n];
        int ans=fibnum(n-1)+fibnum(n-2);
        dp[n]=ans;
        return ans;
    }
}