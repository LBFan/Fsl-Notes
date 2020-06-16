package com.fan.leetcode.search.dfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 组合求和
 * given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [[7],[2, 2, 3]]
 * @date : 2020/02/23.
 */

public class Num08 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, candidates);
        return combinations;
    }

    private void backtracking(ArrayList<Integer> tempCombination, List<List<Integer>> combinations,
                              int start, int target, final int[] candidates) {
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempCombination.add(candidates[i]);
                backtracking(tempCombination, combinations, i, target - candidates[i], candidates);
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}

