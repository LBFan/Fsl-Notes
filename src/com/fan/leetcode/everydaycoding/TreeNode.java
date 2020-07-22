package com.fan.leetcode.everydaycoding;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/04/22.
 */

public class TreeNode {
    int val;
    TreeNode left;

    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

