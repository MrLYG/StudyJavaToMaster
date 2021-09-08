package binarytree;

/**
 * @Author: Ken
 * @Date: 2021/8/30 12:44
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "["  + val +
                ", [" + left +
                "], [" + right +
                "]";
    }
}