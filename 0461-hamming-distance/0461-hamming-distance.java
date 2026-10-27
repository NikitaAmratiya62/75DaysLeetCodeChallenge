class Solution {
    public int hammingDistance(int x, int y) {
        int n=x^y;
        int distance=0;
        while(n>0){
            distance +=(n&1) ;
            n=n>>1;
        }
        return distance;
    }
}