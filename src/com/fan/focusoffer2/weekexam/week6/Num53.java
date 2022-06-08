package com.fan.focusoffer2.weekexam.week6;

import com.fan.focusoffer2.TreeNode;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 二叉搜索树的下一个节点
 * @date : 2022/4/9 10:33.
 */

public class Num53 {

    public TreeNode nextNode(TreeNode root, TreeNode p) {
        //TreeNode ans = null;
        //while (root != null) {
        //    if (root.val > p.val) {
        //        ans = root;
        //        root = root.left;
        //    } else {
        //        root = root.right;
        //    }
        //}
        //
        //return ans;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 知道这里为什么要stack不为空
        while (cur != null || !stack.isEmpty()) {
            while (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.peek().val > p.val) {
                return stack.peek();
            }
            // cur：当前节点是栈顶元素的下一个节点
            cur = stack.pop().right;

        }
        return null;
    }
}

