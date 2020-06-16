package com.fan.leetcode.bitcompute;

/**
 * @author :  PF_23
 * @Description : 数组中不重复的两个元素
 * @date : 2020/02/13.
 */

public class Num04 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // 得到diff中最右一位1
        diff &= -diff;
        int[] res = new int[2];
        for (int num :nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}

