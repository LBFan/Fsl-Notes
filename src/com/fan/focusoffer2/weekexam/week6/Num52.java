package com.fan.focusoffer2.weekexam.week6;

import com.fan.focusoffer2.TreeNode;

/**
 * @author : PF_23
 * @Description : 展平二叉搜索树
 * @date : 2022/4/9 10:12.
 */

public class Num52 {

    TreeNode prev;
    TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
        // 中序遍历
        dfs(root);
        return head;

    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null) {
            prev.right = root;
            root.left = null;
        } else {
            head = root;
        }
        prev = root;
        dfs(root.right);
    }
}

