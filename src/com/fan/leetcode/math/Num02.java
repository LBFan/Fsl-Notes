package com.fan.leetcode.math;

/**
 * @author :  PF_23
 * @Description : 最大公约数
 * @date : 2020/02/25.
 */

public class Num02 {
    int gcb(int a, int b) {
        return b == 0 ? a : gcb(b, a % b);
    }

    /**
     * 最小公倍数为两数的乘积除以最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    int lcm(int a, int b) {
        return a * b / gcb(a, b);
    }
}

