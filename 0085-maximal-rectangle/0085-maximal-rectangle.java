class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int[] nse=new int[n];
        nse[n-1]=n;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i])  st.pop();
            if(st.size()==0) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        while(st.size()>0) st.pop();
        int[] pse=new int[n];
        pse[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<n;i++){
            int area=arr[i]*(nse[i]-pse[i]-1);
            maxarea=Math.max(area,maxarea);
        }
        return maxarea;
    }
    public int maximalRectangle(char[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[] hi=new int[n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]=='1') hi[j]++;
                else hi[j]=0;
            }
            max=Math.max(max,largestRectangleArea(hi));
        }
        return max;
    }
}