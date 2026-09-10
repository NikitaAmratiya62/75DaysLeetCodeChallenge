class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if (root == null)  return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        int size = size(root);
        int avg = (left + right + root.val) / size;
        if (avg == root.val)  count++;
        averageOfSubtree(root.left);
        averageOfSubtree(root.right);
        return count;
    }

    public int sum(TreeNode root) {
        if (root == null)  return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    public int size(TreeNode root) {
        if (root == null)  return 0;
        return 1 + size(root.left) + size(root.right);
    }
}