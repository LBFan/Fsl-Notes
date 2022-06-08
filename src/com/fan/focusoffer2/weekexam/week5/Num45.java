package com.fan.focusoffer2.weekexam.week5;

import com.fan.focusoffer2.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : PF_23
 * @Description : 二叉树最底层最左边的值
 * @date : 2022/4/3 10:51.
 */

public class Num45 {

    public int leftVal(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root);
        int leftval = root.val;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) {
                queue2.offer(node.left);
            }

            if (node.right != null) {
                queue2.offer(node.right);
            }

            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if (!queue1.isEmpty()) {
                    leftval = queue1.peek().val;
                }
            }

        }
        return leftval;
    }
}

