
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int is, int ie,
                          int[] postorder, int ps, int pe) {

        if (is > ie || ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);

        int index = is;
        while (inorder[index] != postorder[pe]) {
            index++;
        }

        int leftSize = index - is;

        root.left = build(inorder, is, index - 1,
                          postorder, ps, ps + leftSize - 1);

        root.right = build(inorder, index + 1, ie,
                           postorder, ps + leftSize, pe - 1);

        return root;
    }
}
