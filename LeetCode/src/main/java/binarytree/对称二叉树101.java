package binarytree;

/**
 * @Author: Ken
 * @Date: 2021/9/3 14:03
 */
class Q101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || checkSymmetric(root.left, root.right);
    }

    public boolean checkSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;
        else if (leftTree != null && rightTree != null) {
            return leftTree.val == rightTree.val &&
                    checkSymmetric(leftTree.left, rightTree.right) && checkSymmetric(leftTree.right, rightTree.left);
        }
        return false;
    }
}
