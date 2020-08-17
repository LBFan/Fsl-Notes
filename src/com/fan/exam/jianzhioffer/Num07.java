package com.fan.exam.jianzhioffer;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 重建二叉树
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num07 {
    /**
     * 缓存中序遍历数组每个值对应的索引
     */
    private static Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            // 递归退出条件 !!!
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        Integer inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
//        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inIndex + 1);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {2, 1, 3};
        int[] pre = {1, 2, 3};
        TreeNode treeNode = reConstructBinaryTree(in, pre);

    }
}
