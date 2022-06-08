package com.fan.focusoffer2.weekexam.week6;

import com.fan.focusoffer2.TreeNode;

import java.util.List;

/**
 * @author : PF_23
 * @Description : 二叉搜索树中两个节点值之和
 * @date : 2022/4/9 11:10.
 */

public class Num56 {

    List<Integer> nums;

    public boolean twoSum(TreeNode root, int k) {
        // 中序遍历，双指针
        dfs(root);
        //双指针
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) == k) {
                return true;
            } else if (nums.get(i) + nums.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
        //Stack<TreeNode> stack = new Stack<>();
        //TreeNode cur = root;
        //while (cur != null || !stack.isEmpty()) {
        //    while (cur != null) {
        //        stack.push(cur);
        //        cur = cur.left;
        //    }
        //    cur = stack.pop();
        //    if ()
        //}
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        nums.add(root.val);
        dfs(root.right);
    }

}

