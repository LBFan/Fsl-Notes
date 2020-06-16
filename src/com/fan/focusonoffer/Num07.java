package com.fan.focusonoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 重建二叉树
 * 递归 TODO : 有待理解
 * 通过画图帮助理解
 * @date : 2019/12/12.
 */

public class Num07 {
    /**
     * 缓存中序遍历数组每个值对应的索引
     */
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    /**
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        Integer inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL  +leftTreeSize + 1, preR,
                inL + leftTreeSize + 1);
        return root;
    }
}

