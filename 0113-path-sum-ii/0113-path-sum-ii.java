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
    public void dfs(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> path) {
        if(root==null) return;
        path.add(root.val);
        if(root.left==null && root.right==null && targetSum==root.val){
            ans.add(new ArrayList<>(path));
        }
        else{
            dfs(root.left,targetSum-root.val,ans,path);
            dfs(root.right,targetSum-root.val,ans,path);
        }
        path.remove(path.size()-1);
        

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        dfs(root,targetSum,ans,path);
        return ans;

    }
}