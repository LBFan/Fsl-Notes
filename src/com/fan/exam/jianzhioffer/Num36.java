package com.fan.exam.jianzhioffer;

/**
 * @Description : 二叉搜索树和双向链表 （中序遍历）
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num36 {
    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre = cur.left;
        } else {
            head = cur;
        }

        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
