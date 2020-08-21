//package com.fan.exam.jianzhioffer;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Stack;
//
///**
// * @Description : 二叉树的前中后序遍历
// * @Author : shulin.fan
// * @Date : 2020/8/19
// */
//public class OrderTree {
//
//    /**
//     * 非递归前序遍历二叉树
//     *
//     * @param root 根节点
//     * @return res
//     */
//    public List<Integer> preOrderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node != null) {
//                res.add(node.val);
//                stack.push(node.right);
//                stack.push(node.left);
//            }
//        }
//        return res;
//    }
//
//    /**
//     * 非递归中序遍历二叉树
//     *
//     * @param root 根节点
//     * @return res
//     */
//    public List<Integer> inOrderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        while (!stack.isEmpty() || cur != null) {
//            while (cur != null) {
//                stack.add(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            res.add(cur.val);
//            cur = cur.right;
//        }
//        return res;
//    }
//
//    /**
//     * 非递归后序遍历二叉树
//     *
//     * @param root 根节点
//     * @return res
//     */
//    public List<Integer> postOrderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node != null) {
//                res.add(node.val);
//                stack.push(node.left);
//                stack.push(node.right);
//            }
//        }
//        Collections.reverse(res);
//        return res;
//    }
//}
