package com.fan.focusoffer2.weekexam.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 和为k的子数组个数
 * @date : 2022/3/5 14:01.
 */

public class Num10 {

    public int subSum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int count = 0;
        // 和为0的首先出现了一次
        int sum = 0;
        sumCount.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += sumCount.getOrDefault(sum - k, 0);
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

