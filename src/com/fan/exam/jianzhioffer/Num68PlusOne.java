//package com.fan.exam.jianzhioffer;
//
///**
// * @Description : 普通二叉树 两个节点的最低公共祖先
// * @Author : shulin.fan
// * @Date : 2020/7/19
// */
//public class Num68PlusOne {
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // 注意边界条件
//        if (root == null || root == p || root == q) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        return left == null ? right : right == null ? left : root;
//    }
//}
