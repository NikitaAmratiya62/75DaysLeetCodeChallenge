class Solution {
    public int findNumbers(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            int digcount=0;
            while(n>0){
                int digit=n%10;
                digcount++;
                n=n/10;
            }
            if(digcount%2==0) total++;
        }
        return total;
    }
}