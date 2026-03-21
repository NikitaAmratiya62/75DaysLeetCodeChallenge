class Solution {
    public void moveZeroes(int[] num) {
        int n= num.length;
        int idx=0;
        for(int i=0;i<n;i++){
            if(num[i]!=0){
              num[idx]=num[i];
              idx++;
            }
        }
        while(idx < n){
          num[idx]=0;
          idx++;
        }
    }
}