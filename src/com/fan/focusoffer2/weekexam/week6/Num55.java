package com.fan.focusoffer2.weekexam.week6;

import com.fan.focusoffer2.TreeNode;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 二叉搜索树迭代器
 * @date : 2022/4/9 10:58.
 */

public class Num55 {

    TreeNode cur;

    Stack<TreeNode> stack;

    public Num55(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;

        return val;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}

