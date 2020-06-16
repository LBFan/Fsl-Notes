package com.fan.leetcode.search.dfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 输出二叉树中所有从根到叶子的路径
 *
 *  1
 *  /  \
 * 2    3
 *  \
 *   5
 * ["1->2->5", "1->3"]
 * @date : 2020/02/23.
 */

public class Num04 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    private void backtracking(TreeNode root, List<Integer> values, List<String> paths) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        if (isLeaf(root)) {
            paths.add(buildPath(values));
        } else {
            backtracking(root.left, values, paths);
            backtracking(root.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }
}

