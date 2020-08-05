package com.fan.exam.jianzhioffer;

/**
 * @Description : 二叉树的镜像
 * 输出镜像
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num27 {
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
    }
}
