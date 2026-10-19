class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int s=0,e=n-1;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                arr[s++]=nums[i];
            }
            else{
                arr[e--]=nums[i];
            }
        }
        return arr;
    }
}