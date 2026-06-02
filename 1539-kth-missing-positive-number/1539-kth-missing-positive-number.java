class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo=0,hi=arr.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int correctno=mid+1;
            int missingno=arr[mid]-correctno;
            if(missingno>=k) hi=mid-1;
            else
               lo=mid+1;
        }
        return hi+1+k;
    }
}