class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        // positive count
        int lo=0,hi=n-1,fstpos=n;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>0){
                fstpos=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        // /negative count
        lo=0;
        hi=n-1;
        int lastneg=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<0){
                lastneg=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }
        int negcount=lastneg+1;
        int poscount=n-fstpos;
            
        return Math.max(negcount,poscount);
    }
}