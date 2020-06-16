package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 树的子结构
 * 判断B是否是A 的子结构，规定空树不是任何树的子结构
 * @date : 2019/12/24.
 */

public class Num26 {
    public boolean isSubbTree(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubbTree(A.left, B) || isSubbTree(A.right, B) || isSubtreeWithRoot(A, B);
    }

    private boolean isSubtreeWithRoot(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        if (b == null) {
            return true;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSubtreeWithRoot(a.left, b.left) && isSubtreeWithRoot(a.right, b.right);
    }
}

