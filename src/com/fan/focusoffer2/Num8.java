package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : 双指针
 * 和大于等于k的最短子数组
 * @date : 2022/3/3 22:05.
 */

public class Num8 {

    public int minLen(int[] nums, int k) {
        int result = nums.length + 1;
        int i = 0;
        int j = 0;
        int sum = 0;
        for (; j < nums.length; j++) {
            sum += nums[j];
            while (i <= j && sum >= k) {
                result = Math.min(j - i + 1, result);
                sum -= nums[i++];
            }
        }

        return result == nums.length + 1 ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 6, 3, 2};
        int k = 10;
        Num8 num8 = new Num8();
        int minLen = num8.minLen(nums, k);
        System.out.println(minLen);
    }
}

