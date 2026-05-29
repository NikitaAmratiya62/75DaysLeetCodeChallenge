class Solution {
    public int arrangeCoins(int n) {
        int lo=0,hi=n,ans=0;
        while(lo<=hi){
            int k=lo+(hi-lo)/2;
            long m=(long)k*(k+1)/2;
            if(m==n) return k;
            else if(m>n) hi=k-1;
            else{
                ans=k;
                lo=k+1;
            }

        }
        return ans;

    }
}