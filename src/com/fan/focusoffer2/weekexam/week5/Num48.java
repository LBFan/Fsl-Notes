package com.fan.focusoffer2.weekexam.week5;

import com.fan.focusoffer2.TreeNode;

/**
 * @author : PF_23
 * @Description : 序列化和反序列化二叉树
 * @date : 2022/4/3 11:11.
 */

public class Num48 {

    public String serialize(TreeNode root) {
        // 前序遍历
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // 反序列化
    public TreeNode reSerialize(String str) {
        String[] strs = str.split(",");
        int[] i = {0};
        return dfs(strs, i);
    }

    private TreeNode dfs(String[] strs, int[] i) {
        String str = strs[i[0]];
        i[0]++;
        if ("#".equals(str)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = dfs(strs, i);
        node.right = dfs(strs, i);
        return node;
    }
}

