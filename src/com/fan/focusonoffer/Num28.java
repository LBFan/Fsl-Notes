package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 对称的二叉树
 * @date : 2019/12/24.
 */

public class Num28 {
    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    private boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }

    public static void main(String[] args) {
        System.out.println(Math.round(-1.5));
    }
}

