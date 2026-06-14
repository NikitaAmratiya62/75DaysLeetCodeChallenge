class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int i=0,k=0;
        while(i<n){
            int j=i;
            while(j<n && chars[i]==chars[j]){
                j++;
            }
            int len=j-i;
            chars[k++]=chars[i];
            if(len>1){
                String s=Integer.toString(len);
                for(char c:s.toCharArray()){
                    chars[k++]=c;
                }
            }
            i=j;
        }
        return k;
    }
}