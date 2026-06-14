class Solution {
    public String reverseWords(String s) {
        String[] arr=s.trim().split("\\s+");
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<arr.length;i++){
           int n= arr[i].length();
           for(int j=n-1;j>=0;j-- ){
            ans.append(arr[i].charAt(j));
           }

           if(i!=arr.length-1) ans.append(" ");
        }
        return ans.toString();
    }
}