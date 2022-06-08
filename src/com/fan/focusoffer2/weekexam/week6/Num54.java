package com.fan.focusoffer2.weekexam.week6;

import com.fan.focusoffer2.TreeNode;

/**
 * @author : PF_23
 * @Description : 所有大于或等于节点的值之和
 * @date : 2022/4/9 10:49.
 */

public class Num54 {

    TreeNode prev;
    public TreeNode sumThan(TreeNode root) {
        // 反中序
        prev = new TreeNode(0);
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        root.val += prev.val;
        prev = root;
        dfs(root.left);
    }
}

