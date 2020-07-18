package com.fan.exam.jianzhioffer;


/**
 * @Description : 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num55PlusOne {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }
}
