package com.fan.exam.jianzhioffer;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num34 {
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            // 找到一条路径
            ret.add(path);
        } else {
            if (root.left != null) {
                backtracking(root.left, target, path);
            }
            if (root.right != null) {
                backtracking(root.right, target, path);
            }
        }
        // 回溯
        path.remove(path.size() - 1);
    }

}
