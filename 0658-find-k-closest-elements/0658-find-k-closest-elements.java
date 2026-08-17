class Triplet implements Comparable<Triplet> {
    int a;
    int x;
    int dist;
    Triplet(int a,int x,int dist){
        this.a=a;
        this.x=x;
        this.dist=dist;
    }
    public int compareTo(Triplet t) {
       if(this.dist!=t.dist) return Integer.compare(this.dist,t.dist);
       return Integer.compare(this.a,t.a);
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<Triplet> pq =new PriorityQueue<>(Collections.reverseOrder());
            for(int ele : arr){
                int d=Math.abs(ele-x);
                pq.add(new Triplet(ele,x,d));
                if(pq.size()>k) pq.remove();
            }
            for(int i=0;i<k;i++){
                Triplet top=pq.remove();
                ans.add(top.a);
            }
            Collections.sort(ans);
        
        return ans;
    }
}