class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            int n=stones.length;
            for(int i=0;i<n;i++){
                pq.add(stones[i]);
            }
            while(pq.size()>1){
                int f=pq.remove();
                int s=pq.remove();
                if(f!=s){
                    int diff=f-s;
                    pq.add(diff);
                }
            }
        if(pq.size()==1) return pq.peek();
        return 0;
    }
}