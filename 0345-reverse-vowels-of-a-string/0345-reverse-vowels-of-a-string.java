class Solution {
     public boolean isVowels(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='E'||ch=='A'||ch=='I'||ch=='O'||ch=='U';
     }
    public String reverseVowels(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int i=0,j=n-1;
        while(i<j){
            while(i<j && !isVowels(arr[i]) ){
                i++;
            }
            while(i<j && !isVowels(arr[j]) ){
                j--;
            }
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return new String(arr);

    }
}