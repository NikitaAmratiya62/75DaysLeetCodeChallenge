class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int [][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=digitsum(nums[i]);
        }
        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        Map<Integer, Integer> position=new HashMap<>();
        for(int i=0;i<n;i++){
            position.put(nums[i],i);
        }
        int swap=0;
        for(int i=0;i<n;i++){
            int correctvalue=arr[i][0];
            if(nums[i]!=correctvalue){
                int j=position.get(correctvalue);
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                swap++;
                position.put(nums[i],i);
                position.put(nums[j],j);
            }
        }
        return swap;
    }
    public int digitsum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}