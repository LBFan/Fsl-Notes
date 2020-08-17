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
        long b = exponent;
        if (b < 0) {
            b = -b;
            base = 1 / base;
        }

        double res = 1.0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= base;
            }
            base *= base;
            b >>= 1;
        }
        return res;
    }
}
