class Solution {
    public int values(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int curr=values(s.charAt(i));
            if(i+1<n && curr<values(s.charAt(i+1))) ans-=curr;
            else ans+=curr;
        }
        return ans;
    }
}