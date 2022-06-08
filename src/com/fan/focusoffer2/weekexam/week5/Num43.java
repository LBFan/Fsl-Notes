package com.fan.focusoffer2.weekexam.week5;

import com.fan.focusoffer2.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : PF_23
 * @Description : 在完全二叉树中添加节点
 * @date : 2022/4/3 10:23.
 */

public class Num43 {

    private Queue<TreeNode> queue;
    private TreeNode root;

    /**
     * 在初始化过程就要找到第一个左子节点或右子节点为空的节点
     */
    public Num43(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();

        queue.offer(root);


        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        TreeNode newNode = new TreeNode(v);

        if (node.left == null) {
            // 左子节点为空
            node.left = newNode;
        } else {
            node.right = node;
            queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return node.val;
    }

    public TreeNode getRoot() {
        return this.root;
    }
}

