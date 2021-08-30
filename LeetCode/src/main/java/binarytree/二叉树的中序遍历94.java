package binarytree;

import java.awt.geom.Arc2D;
import java.util.*;

/**
 * @Author: Ken
 * @Date: 2021/8/23 14:06
 */
class Q94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //递归解法
//        look(root, list);
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }


        return list;

    }

    public void look(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add((root.val));
        look(root.left, list);

        look(root.right, list);

    }


}
