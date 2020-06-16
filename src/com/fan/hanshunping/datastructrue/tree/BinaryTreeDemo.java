package com.fan.hanshunping.datastructrue.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 二叉树遍历
 * 前序遍历、中序遍历、后序遍历、层次遍历
 * 递归和非递归
 * @date : 2020/04/15.
 */

public class BinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(6);

        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;

        System.out.println("非递归前序遍历");
        preOrder(root);
        System.out.println("非递归中序遍历");
        inOrder(root);
        System.out.println("非递归后序遍历");
        postOrder(root);
        System.out.println("层次遍历");
        levelOrder(root);

    }

    /**
     * 前序遍历（递归）
     *
     * @param root
     */
    public static void preOrderRe(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + " \t");
            preOrderRe(root.left);
            preOrderRe(root.right);
        }
        System.out.println();
    }

    /**
     * 前序遍历（非递归）
     *
     * @param root
     */
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.val + "\t");
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.right;
        }
        System.out.println();
    }

    /**
     * 中序遍历（递归）
     *
     * @param root
     */
    public static void inOrderRe(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val + "\t");
            inOrder(root.right);
        }
        System.out.println();
    }

    /**
     * 中序遍历（非递归）
     *
     * @param root
     */
    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            System.out.print(root.val + "\t");
            root = root.right;
        }
        System.out.println();
    }

    /**
     * 后序遍历（递归）
     *
     * @param root
     */
    public static void postOrderRe(TreeNode root) {
        if (root != null) {
            postOrderRe(root.left);
            postOrderRe(root.right);
            System.out.print(root.val + "\t");
        }
        System.out.println();
    }

    /**
     * 后序遍历（非递归）
     *
     * @param root
     */
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                // 当前节点没有右子节点
                if (null == stack.peek().right) {
                    root = stack.pop();
                    System.out.print(root.val + "\t");
                    while (root == stack.peek().right) {
                        System.out.print(stack.peek().val + "\t");
                        root = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    root = stack.peek().right;
                } else {
                    root = null;
                }
            }
        }
        System.out.println();
    }

    /**
     * 层次遍历
     *
     * @param root 根节点
     */
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                temp = queue.poll();
                System.out.print(temp.val + "\t");
                if (null != temp.left) {
                    queue.add(temp.left);
                }
                if (null != temp.right) {
                    queue.add(temp.right);
                }
            }
        }
    }


    /**
     * 删除指定的结点
     * 如果该非叶子节点A只有一个子节点B，则子节点B替代节点A
     * 如果该非叶子节点A有左子节点B和右子节点C，则让左子节点B替代节点A。
     *
     * @param no 结点编号
     */
    public void delNode(int no) {

    }
}

