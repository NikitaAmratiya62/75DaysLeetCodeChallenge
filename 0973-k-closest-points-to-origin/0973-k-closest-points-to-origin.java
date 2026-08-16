class Triplet implements Comparable<Triplet> {
    int x;
    int y;
    int dist;
    Triplet(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
    public int compareTo(Triplet t) {
        return this.dist-t.dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int[] point:points){
            int x=point[0],y=point[1];
            int dist=x*x+y*y;
            pq.add(new Triplet(x,y,dist));
            if(pq.size()>k) pq.remove();
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            Triplet top=pq.remove();
            ans[i][0]=top.x;
            ans[i][1]=top.y;
        }
        return ans;

    }
}