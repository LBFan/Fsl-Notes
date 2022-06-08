package com.fan.focusoffer2.weekexam.week1;

/**
 * @author : PF_23
 * @Description : 乘积小于K的子数组
 * @date : 2022/3/5 13:47.
 */

public class Num9 {

    public int subArrayProduct(int[] nums, int k) {
        int res = 0;
        // 双指针
        int p1 = 0, p2 = 0;
        int product = 1;
        for (; p2 < nums.length; p2++) {
            product *= nums[p2];
            while (p1 <= p2 && product >= k) {
                product /= nums[p1++];
            }
            res += p1 <= p2 ? p2 - p1 + 1 : 0;
        }

        return res;
    }
}

