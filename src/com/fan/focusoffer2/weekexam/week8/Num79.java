package com.fan.focusoffer2.weekexam.week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 所有子集,回溯
 * @date : 2022/5/14 10:48.
 */

public class Num79 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        helper(nums, 0, new LinkedList<>(), result);
        return result;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            // 说明当前子集已经组合完毕
            result.add(new LinkedList<>(subset));
        } else if (index < nums.length) {
            // 不考虑将下一个数字放入组合中
            helper(nums, index + 1, subset, result);

            // 考虑将下标为index的数字放入组合汇总，，接下来掉用递归函数处理数组nums中的下一个数字
            subset.add(nums[index]);
            helper(nums, index + 1, subset, result);
            //处理完成后需要回溯，删除放入到subset组合中的最后一个数字，nums[index]
            subset.removeLast();
        }
    }
}

