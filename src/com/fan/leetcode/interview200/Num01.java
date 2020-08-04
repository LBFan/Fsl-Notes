package com.fan.leetcode.interview200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 两数之和
 * 暴力 -> 两遍哈希 -> 一遍哈希算法
 * @date : 2020/07/30.
 */

public class Num01 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compare = target - nums[i];
            if (map.containsKey(compare)) {
                return new int[]{i, map.get(compare)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

