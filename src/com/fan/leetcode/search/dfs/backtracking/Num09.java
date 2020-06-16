package com.fan.leetcode.search.dfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 含有相同元素的组合求和
 * @date : 2020/02/23.
 */

public class Num09 {
    public List<List<Integer>> combinationsSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), combinations, new boolean[candidates.length],0, target, candidates);
        return combinations;
    }

    private void backtracking(ArrayList<Integer> tempCombinations,
                              List<List<Integer>> combinations, boolean[] hasVisited, int start,
                              int target,
                              final int[] candidates) {
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombinations));
            return;
        }
        for (int i = start; i <= candidates.length ; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                tempCombinations.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(tempCombinations, combinations, hasVisited, i + 1,
                        target - candidates[i], candidates);
                hasVisited[i] = false;
                tempCombinations.remove(tempCombinations.size() - 1);
            }

        }
    }
}

