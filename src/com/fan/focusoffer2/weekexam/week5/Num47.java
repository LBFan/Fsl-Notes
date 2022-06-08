package com.fan.focusoffer2.weekexam.week5;

import com.fan.focusoffer2.TreeNode;

/**
 * @author : PF_23
 * @Description : 二叉树剪枝
 * @date : 2022/4/3 11:05.
 */

public class Num47 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        // 后序遍历：左右子节点为空并且当前节点为0，剪枝
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 当前节点为0，左右子树为空，则返回null
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}

