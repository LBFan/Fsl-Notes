package com.fan.exam.jianzhioffer;

import java.util.*;

/**
 * @Description : 二叉树的遍历（从上往下打印二叉树 二叉树层次遍历、把二叉树打印成多行、按之字形顺序打印二叉树）
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num32 {
    /**
     * 从上往下打印二叉树 二叉树层次遍历 BFS
     *
     * @param root 根节点
     * @return 集合
     */
    public static List<Integer> printFromTopToBottom(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode t;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                t = queue.poll();
                if (t == null) {
                    continue;
                }
                res.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return res;
    }

    /**
     * 打印成多行
     *
     * @param root 根节点
     * @return 嵌套集合
     */
    public static List<List<Integer>> print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode t;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (cnt-- > 0) {
                t = queue.poll();
                if (t == null) {
                    continue;
                }
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            if (tmp.size() > 0) {
                res.add(tmp);
            }
        }
        return res;
    }

    /**
     * Z字打印
     *
     * @param root 根节点
     * @return 嵌套集合
     */
    public static List<List<Integer>> printByZ(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            TreeNode node = queue.poll();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (tmp.size() > 0) {
                res.add(tmp);
            }
        }
        return res;
    }

}
