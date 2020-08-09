package com.fan.exam.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 序列化与反序列化二叉树
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num37 {

    /**
     * 借助队列
     *
     * @param root root
     * @return string
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();

    }

    /**
     * 借助队列实现反序列化
     *
     * @param data string
     * @return treenode
     */
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(vals[i])) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!"null".equals(vals[i])) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    TreeNode root;
    // Encodes a tree to a single string.
    //public String serialize(TreeNode root) {
    //    this.root = root;
    //    return null;
    //}

    // Decodes your encoded data to tree.
    //public TreeNode deserialize(String data) {
    //    return root;
    //}
}
