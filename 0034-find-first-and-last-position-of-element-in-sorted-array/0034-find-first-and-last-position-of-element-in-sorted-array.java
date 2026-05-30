class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] ans=new int[2];
        int lo=0,hi=n-1,fstpos=-1,lstpos=-1;
        // first position
        while(lo<=hi) {
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>target) hi=mid-1;
            else if(nums[mid]<target) lo=mid+1;
            else{
                fstpos=mid;
                hi=mid-1;
            }
        }
        lo=0;
        hi=n-1;
        // last position
        while(lo<=hi) {
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>target) hi=mid-1;
            else if(nums[mid]<target) lo=mid+1;
            else{
                lstpos=mid;
                lo=mid+1;
            }
        }
        ans[0]=fstpos;
        ans[1]=lstpos;
        return ans;
    }
}