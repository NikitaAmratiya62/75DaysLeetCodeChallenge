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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int ps,int pe ,int[] inorder,int is,int ie){
        if(ps>pe || is>ie) return null;
        TreeNode root=new TreeNode(preorder[ps]);
        int index=is;
        while(preorder[ps]!=inorder[index]){
            index++;
        }
        int leftsize=index-is;
        root.left=build(preorder,ps+1,leftsize+ps,inorder,is,index-1);
        root.right=build(preorder,ps+1+leftsize,pe,inorder,index+1,ie);
        return root;
    }
}