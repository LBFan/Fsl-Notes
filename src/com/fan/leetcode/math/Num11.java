package com.fan.leetcode.math;

/**
 * @author :  PF_23
 * @Description : 3 的 n 次方
 * @date : 2020/02/25.
 */

public class Num11 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}

