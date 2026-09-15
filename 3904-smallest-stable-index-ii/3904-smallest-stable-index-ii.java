class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] minarr=new int[n];
        minarr[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            minarr[i]=Math.min(minarr[i+1],nums[i]);
        }
        int maxleft=nums[0];
        for(int i=0;i<n;i++){
            maxleft=Math.max(maxleft,nums[i]);
            int minright=minarr[i];
            if(maxleft-minright<=k) return i;
        }

        return -1;
    }
}