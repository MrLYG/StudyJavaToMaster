package binarytree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: Ken
 * @Date: 2021/8/31 9:33
 */
class Q129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int temp = i*10+root.val;
        if (root.right == null && root.left == null){
            return temp;
        }else {
            return dfs(root.left,temp)+dfs(root.right,temp);
        }
    }


}
