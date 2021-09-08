package binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Ken
 * @Date: 2021/9/8 16:52
 */
public class 剑指Offer26树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return  false;
        Deque<TreeNode> stack = new LinkedList<>();
        while (stack != null || A != null) {
            while (A != null) {
                stack.push(A);
                A = A.left;
            }
            A = stack.pop();
            if(recur(A,B)){
                return true;
            }
            A = A.right;
        }
        return false;
    }
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null ) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
