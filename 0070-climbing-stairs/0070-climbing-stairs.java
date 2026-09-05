class Solution {
    static int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        return stairs(n);
    }
    public int stairs(int n) {
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        int ans=stairs(n-1)+stairs(n-2);
        dp[n]=ans;
        return ans;
    }
}