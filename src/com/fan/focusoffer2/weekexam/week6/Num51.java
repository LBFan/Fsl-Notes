package com.fan.focusoffer2.weekexam.week6;


import com.fan.focusoffer2.TreeNode;

/**
 * @author : PF_23
 * @Description : 节点值之和最大的路径
 * @date : 2022/4/9 09:39.
 */

public class Num51 {

    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        // 返回当前节点为起始节点的能为上一层节点贡献的最大路径和，只能当前节点值 + max(当前节点的左路径，当前节点的右路径)
        dfs(root, maxSum);
        return maxSum[0];
    }

    private int dfs(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        // 左子树的全局最大值
        int[] maxSumLeft = {Integer.MIN_VALUE};
        // 左子树对上一层节点的最大贡献值
        int leftSum = Math.max(0, dfs(root.left, maxSumLeft));

        // 同上
        int[] maxSumRight = {Integer.MIN_VALUE};
        int rightSum = Math.max(0, dfs(root.left, maxSumRight));

        maxSum[0] = Math.max(maxSumLeft[0], maxSumRight[0]);

        maxSum[0] = Math.max(maxSum[0], root.val + leftSum + rightSum);
        // 当前函数结果返回的是当前节点对上一层的最大贡献值，只能取左右子树的更大值
        return root.val + Math.max(leftSum, rightSum);
    }
}

