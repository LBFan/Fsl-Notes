package com.fan.focusoffer2.weekexam.week5;

import com.fan.focusoffer2.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : PF_23
 * @Description : 二叉树中每层的最大值
 * @date : 2022/4/3 10:38.
 */

public class Num44 {

    /**
     * 使用双队列
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int current = 0;
        int next = 0;
        if (root != null) {
            queue.offer(root);
            current++;
        }

        List<Integer> result = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            // 求出当前层的最大值
            TreeNode node = queue.poll();
            maxVal = Math.max(maxVal, node.val);
            current--;
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (current == 0) {
                result.add(maxVal);
                maxVal = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }

        }
        return result;
    }

    public List<Integer> largestValues2(TreeNode root) {
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        if (root != null) {
            cur.offer(root);
        }

        List<Integer> result = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;
        while (!cur.isEmpty()) {
            // 求出当前层的最大值
            TreeNode node = cur.poll();
            maxVal = Math.max(maxVal, node.val);
            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }

            if (cur.isEmpty()) {
                result.add(maxVal);
                maxVal = Integer.MIN_VALUE;
                cur = next;
                next = new LinkedList<>();
            }

        }
        return result;
    }
}

