package com.fan.exam.jianzhioffer;

/**
 * @Description : 二叉搜索树和双向链表 （中序遍历）
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num36 {
    public TreeNode pre;
    public TreeNode head;

    public TreeNode treeToDoublyList(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder(root.right);
    }
}
