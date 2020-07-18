package com.fan.exam.jianzhioffer;

/**
 * @Description : 二叉树的深度
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num55 {
    public static int treeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }
}
