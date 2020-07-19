package com.fan.exam.jianzhioffer;

/**
 * @Description : 不用加减乘除等条件判断计算 1+2+...+n的值
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num64 {
    public static int sumWithConditions(int n) {
        int sum = 0;
        boolean b = (n > 0) && (sum += sumWithConditions(n - 1)) > 0;
        return sum;
    }
}
