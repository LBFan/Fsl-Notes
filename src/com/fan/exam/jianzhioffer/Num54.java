//package com.fan.exam.jianzhioffer;
//
///**
// * @Description : 二叉查找树的第 K 个结点 (中序遍历的第K个节点)
// * @Author : shulin.fan
// * @Date : 2020/7/18
// */
//public class Num54 {
//    public static TreeNode ret;
//    private static int cnt = 0;
//
//    public static TreeNode KthNode(TreeNode root, int k) {
//        inOrder(root, k);
//        return ret;
//    }
//
//    private static void inOrder(TreeNode root, int k) {
//        if (root == null || cnt > k) {
//            return;
//        }
//        inOrder(root.right, k);
//        cnt++;
//        if (cnt == k) {
//            ret = root;
//            return;
//        }
//        inOrder(root.left, k);
//    }
//}
