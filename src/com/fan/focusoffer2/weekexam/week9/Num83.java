package com.fan.focusoffer2.weekexam.week9;

import com.fan.hanshunping.datastructrue.sort.SwapUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 没有重复元素集合的全排列
 * @date : 2022/5/21 10:15.
 */

public class Num83 {
    public List<List<Integer>> permute(int[] nums) {
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
            return;
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                helper(nums, i + 1, result);
                swap(nums, i, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

