class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int f=pq.remove();
        int s=pq.remove();
        return (f-1)*(s-1);
    }
}