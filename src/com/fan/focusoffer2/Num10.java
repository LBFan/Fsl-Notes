package com.fan.focusoffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 和为k的子数组,求出
 * 输入一个整数数组和一个整数k，请问数组中有多少个数字之和等于k的连续子数组？
 * 例如，输入数组[1，1，1]，k的值为2，有2个连续子数组之和等于2
 * @date : 2022/3/1 23:09.
 */

public class Num10 {

    public static int subArraySum(int[] nums, int k) {
        // 暴力求解法，算出每一个连续子数组的和，统计和为k的个数
        // 改进：利用hash
        //当扫描到数组的第i个数字并求得前i个数字之和是x时，需要知道在i之前存在多少个j并且前j个数字之和等于x-k
        int count = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count += sumCount.getOrDefault(sum - k, 0);
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,2,3,2,-3,5,7,-5};
        int k = 2;
        int count = subArraySum(nums, k);
        System.out.println(count);
    }
}

