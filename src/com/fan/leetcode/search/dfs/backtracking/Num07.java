package com.fan.leetcode.search.dfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 组合
 *
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @date : 2020/02/23.
 */

public class Num07 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backTracking(combinations, combineList, 1, k, n);
        return combinations;
    }

    private void backTracking(List<List<Integer>> combinations, List<Integer> combineList, int start, int k, final int n) {
        if (k == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        // 剪枝
        for (int i = start; i <= n - k + 1 ; i++) {
            combineList.add(i);
            backTracking(combinations, combineList, i + 1, k - 1, n);
            combineList.remove(combineList.size() - 1);
        }
    }
}

