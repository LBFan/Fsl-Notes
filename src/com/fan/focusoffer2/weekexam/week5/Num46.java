package com.fan.focusoffer2.weekexam.week5;

import com.fan.focusoffer2.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : PF_23
 * @Description : e二叉树的右视图
 * @date : 2022/4/3 10:58.
 */

public class Num46 {

    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 双队列
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (root == null) {
            return result;
        }

        q1.offer(root);
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            if (node.left != null) {
                q2.offer(node.left);
            }
            if (node.right != null) {
                q2.offer(node.right);
            }

            if (q1.isEmpty()) {
                result.add(node.val);
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }

        return result;


    }
}

