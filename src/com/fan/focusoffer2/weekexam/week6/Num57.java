package com.fan.focusoffer2.weekexam.week6;

import java.util.TreeSet;

/**
 * @author : PF_23
 * @Description : 值和下标之差都在给定的范围内
 * @date : 2022/4/9 11:35.
 */

public class Num57 {
    public boolean containValidNum(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 当前set中比nums[i]小的最大值
            Long lower = set.floor((long) nums[i]);
            if (lower != null && (long) nums[i] - lower <= t) {
                return true;
            }

            // 当前set中比nums[i]大的最小值
            Long upper = set.ceiling((long) nums[i]);
            if (upper != null && upper - (long) nums[i] <= t) {
                return true;
            }
            set.add((long) nums[i]);
            // 滑动窗口大小超出最大值，需要将最左边的值移除
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}

