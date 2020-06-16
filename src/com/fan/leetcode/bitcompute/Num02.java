package com.fan.leetcode.bitcompute;

/**
 * @author :  PF_23
 * @Description : 数组中唯一一个不重复的元素
 * @date : 2020/02/13.
 */

public class Num02 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}

