package com.fan.focusoffer2.weekexam.week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 包含重复元素集合的组合，元素可能重复，但是组合不能重复
 * @date : 2022/5/21 10:15.
 */

public class Num82 {

    public List<List<Integer>> method(int[] nums, int target) {
        // 排序，下一个值就是与当前不同的值
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, target, new LinkedList<>(), result);

        return result;
    }

    private void helper(int[] nums, int i, int target, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            //说明已经找到了和为target的组合
            result.add(new LinkedList<>(combination));
            return;
        } else if (target > 0 && i < nums.length) {
            // 不考虑将当前值加入组合中
            helper(nums, getNext(nums, i), target, combination, result);

            // 考虑将当前值加入组合中
            combination.add(nums[i]);
            helper(nums, i + 1, target - nums[i], combination, result);
            // 回溯
            combination.removeLast();
        }
    }

    /**
     * 获得下一个非相同元素的值的下标
     * @param nums
     * @param i
     * @return
     */
    private int getNext(int[] nums, int i) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                return j;
            }
        }
        return nums.length;
    }

}

