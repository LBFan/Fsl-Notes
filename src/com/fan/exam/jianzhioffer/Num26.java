package com.fan.exam.jianzhioffer;

/**
 * @Description : 树的子结构
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num26 {
    public boolean isSubTree(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubTree(A.left, B) || isSubTree(A.right, B) || isSubtreeWithRoot(A, B);
    }

    private boolean isSubtreeWithRoot(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSubtreeWithRoot(a.left, b.left) && isSubtreeWithRoot(a.right, b.right);
    }
}
