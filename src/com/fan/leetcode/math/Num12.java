package com.fan.leetcode.math;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :乘积数组
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 给定一个数组，创建一个新数组，新数组的每个元素为原始数组中除了该位置上的元素之外所有元素的乘积。
 * <p>
 * 要求时间复杂度为 O(N)，并且不能使用除法。
 * @date : 2020/02/25.
 */

public class Num12 {
    /**
     * 我觉得本题可以归结为双指针类型
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);
        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            products[i] *= left;
        }
        int right = 1;
        for (int i = n - 2; i > 0; i--) {
            right *= nums[i + 1];
            products[i] *= right;
        }
        return products;
    }
}

