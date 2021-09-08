package binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Ken
 * @Date: 2021/8/31 11:24
 */
class Q98 {
    //    public boolean isValidBST(TreeNode root) {
//        if (root.right == null && root.left == null) return false;
//        Deque<TreeNode> stack = new LinkedList<>();
//        Integer pre = Integer.MIN_VALUE;
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//
//            if (pre >= root.val) {
//                return false;
//            }
//            pre = root.val;
//            root = root.right;
//        }
//        return true;
//    }
    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) return false;
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        return true;
    }
}
