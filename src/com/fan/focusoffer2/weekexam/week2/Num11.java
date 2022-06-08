package com.fan.focusoffer2.weekexam.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 0和1个数相同的子数组
 * @date : 2022/3/12 09:04.
 */

public class Num11 {


    /**
     * 1.暴力解，算了，
     * 2.换一种思路：如果将0再计算的时候看成-1，那就是-1和1的连续子数组个数相同，也就是和为0的最大长度
     * 那和第10题一样，求连续子数组的和
     * 可以将从第一个数开始的连续子数组的和存入一个哈希表中，值就为和为sum时的当前下标：表示从下标0开始到当前下标的连续子数组的和
     * 如果当前和为sum，下标为i，那么首先需要判断哈希表中是否存在一个下标为j（j < i）的和也为sum， 这样从 j+ 1 个下标开始到第i个下标的
     * 连续子数组的和就为0，
     * 如果不存在这样的下标j的和为sum,就将当前sum的值存入哈希表，map.put(sum , i):
     * 因为这样下次如果出现和为sum的时候，上一次出现和为sum的下标就是当前的i;
     * 如果存在j就不需要再将sum的值变更，因为下一次下标k如果出现了和为sum的连续子数组的话，那么长度应该是k - j,而不是 k - i
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int res = 0;
        Map<Integer, Integer> sumOfIndex = new HashMap<>();
        // 表示当前和为0的最右边下标为-1，也就是说还不存在
        sumOfIndex.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 这里将0当做-1计算
            sum += nums[i] == 0 ? -1 : 1;
            if (sumOfIndex.containsKey(sum)) {
                // 有一个下标 j (j < i), 连续子数组的和为sum
                res = Math.max(i - sumOfIndex.get(sum), res);
            } else {
                // 哈希表中还没有连续子数组和为sum的key-value
                sumOfIndex.put(sum, i);
            }
        }

        return res;
    }
}

