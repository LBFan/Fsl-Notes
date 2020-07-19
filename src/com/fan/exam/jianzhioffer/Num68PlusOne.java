package com.fan.exam.jianzhioffer;

/**
 * @Description : 普通二叉树
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num68PlusOne {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
