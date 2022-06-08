package com.fan.focusoffer2.weekexam.week1;

/**
 * @author : PF_23
 * @Description : 和大于或等于K的最短子数组
 * @date : 2022/3/5 13:37.
 */

public class Num8 {

    public int subArraySumLen(int[] nums, int k) {
        // 利用双指针
        int minLen = nums.length + 1;
        int p1 = 0, p2 = 0;
        int sum = 0;
        for (; p2 < nums.length; p2++) {
            sum += nums[p2];
            while (p1 <= p2 && sum >= k) {
                minLen = Math.min(minLen, p2 -p1 + 1);
                sum -= nums[p1++];
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;
    }
}

