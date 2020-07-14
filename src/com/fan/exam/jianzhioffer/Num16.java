package com.fan.exam.jianzhioffer;

/**
 * @Description : 数字的整数次方
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num16 {
    public static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (base == 1) {
            return base;
        }
        // 注意边界,正负数
        boolean isNegative = (base > 0);
        double res = powerWithUnsignedExponent(base * base, exponent >> 1);
        if (exponent % 2 == 1) {
            res *= base;
        }
        return isNegative ? res : 1 / res;
    }
}
