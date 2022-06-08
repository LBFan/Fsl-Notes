package com.fan.focusoffer2.weekexam.week9;

import com.fan.hanshunping.datastructrue.sort.SwapUtil;

import java.util.*;

/**
 * @author : PF_23
 * @Description : 包含重复元素集合的全排列
 * @date : 2022/5/21 10:16.
 */

public class Num84 {
    public List<List<Integer>> method(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            //说明排列完了
            List<Integer> combination = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                combination.add(nums[j]);
            }
            result.add(new LinkedList<>(combination));
        } else {
            // 如何去重，使用set，记录当前位置是否已经出现过相同数字，如果没出现，则加入进来，出现则跳过
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);

                    SwapUtil.swap(nums, i, j);
                    helper(nums, i + 1, result);
                    SwapUtil.swap(nums, i, j);
                }
            }
        }
    }
}

