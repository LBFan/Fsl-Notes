package com.fan.leetcode.search.dfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 排列
 * [1,2,3] have the following permutations:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @date : 2020/02/23.
 */

public class Num05 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList, permutes, hasVisited, nums);
        return permutes;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes,
                              boolean[] hasVisited, final int[] nums) {
        if (permuteList.size() == nums.length) {
            // 重新构造一个 List
            permutes.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0; i < hasVisited.length; i++) {
            if (hasVisited[i]) {
                continue;
            }
            hasVisited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, permutes, hasVisited, nums);
            permuteList.remove(permuteList.size() - 1);
            hasVisited[i] = false;
        }
    }
}

