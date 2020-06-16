package com.fan.leetcode.search.dfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 含有相同元素求子集
 * For example,
 * If nums = [1,2,2], a solution is:
 *
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * @date : 2020/02/23.
 */

public class Num12 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] hasVisited = new boolean[nums.length];
        for (int size = 0; size <= nums.length; size++) {
            // 不同的子集大小
            backtracking(0, tempSubset, subsets, hasVisited, size, nums);
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets, boolean[] hasVisited, final int size, final int[] nums) {
        if (tempSubset.size() == size) {
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for (int i = start; i <= size; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i]) {
                continue;
            }
            hasVisited[i] = true;
            tempSubset.add(nums[i]);
            backtracking(i + 1, tempSubset, subsets, hasVisited, size, nums);
            hasVisited[i] = false;
            tempSubset.remove(tempSubset.size() - 1);
        }
    }

}

