package com.fan.leetcode.favorate;

import java.util.*;

/**
 * @Description : 组合总和
 * @Author : shulin.fan
 * @Date : 2020/8/19
 */
public class Num24 {

    /**
     * 就是一个普通的回溯算法
     *
     * @param candidates 数组
     * @param target     目标值
     * @return 集合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        //
        Arrays.sort(candidates);
        dfs(candidates, len, target, 0, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int len, int target, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            // 数组有序
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, target - candidates[i], i, path, res);
            path.removeLast();
        }
    }
}
