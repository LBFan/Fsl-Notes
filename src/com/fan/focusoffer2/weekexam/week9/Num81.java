package com.fan.focusoffer2.weekexam.week9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 允许重复选择元素的组合，组合的和为target
 * @date : 2022/5/21 10:14.
 */

public class Num81 {

    public List<List<Integer>> method(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, target, new LinkedList<>(), result);

        return result;
    }

    private void helper(int[] nums, int i, int target, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            //说明已经找到了和为target的组合
            result.add(new LinkedList<>(combination));
        } else if (target > 0 && i < nums.length) {
            // 不考虑将当前值加入组合中
            helper(nums, i + 1, target, combination, result);

            // 考虑将当前值加入组合中，由于可以重复加入,
            combination.add(nums[i]);
            helper(nums, i, target - nums[i], combination, result);
            // 回溯
            combination.removeLast();
        }

    }
}

