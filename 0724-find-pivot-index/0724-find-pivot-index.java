class Solution {
    public int sum(int[] nums,int s,int e){
        int sum=0;
        for(int j=s;j<=e;j++){
            sum+=nums[j];
        }
        return sum;
    }
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int leftsum;
        int rightsum;
        int pivot=-1;
        for(int i=0;i<n;i++){
            if(i==0) {
                leftsum=0;
                rightsum=sum(nums,1,n-1);
            }
            else if(i==n-1){
                leftsum=sum(nums,0,n-2);
                rightsum=0;
            }
            else{
                leftsum=sum(nums,0,i-1);
                rightsum=sum(nums,i+1,n-1);
            }
            if(leftsum==rightsum) {
                pivot=i;
                break;
            }
            leftsum=0;
            rightsum=0;
        }
        return pivot;
    }
}