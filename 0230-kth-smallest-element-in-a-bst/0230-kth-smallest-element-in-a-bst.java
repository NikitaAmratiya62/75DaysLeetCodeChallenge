/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int ans=traverse(root,k,pq);
        return ans;
    }
    public int traverse(TreeNode root,int k,PriorityQueue<Integer> pq){
        if(root==null) return 0;
        pq.add(root.val);
        if(pq.size()>k) pq.remove();
        traverse(root.left,k,pq);
        traverse(root.right,k,pq);
        return pq.peek();
    }
}