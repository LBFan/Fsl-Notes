package com.fan.focusoffer2.weekexam.week5;

import com.fan.focusoffer2.TreeNode;

/**
 * @author : PF_23
 * @Description : 从根节点到叶子节点的路劲之和
 * @date : 2022/4/3 11:21.
 */

public class Num49 {

    public int sum(TreeNode root) {
        //
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }

        path = path * 10 + root.val;

        // 前序遍历
        if (root.left == null && root.right == null) {
            return path;
        }
        return dfs(root.left, path) + dfs(root.right, path);
    }
}

