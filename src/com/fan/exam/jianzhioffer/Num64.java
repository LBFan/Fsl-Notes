package com.fan.exam.jianzhioffer;

/**
 * @Description : 不用乘除等条件判断计算 1+2+...+n的值
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num64 {
    public static int sumWithConditions(int n) {
        boolean flag = n > 0 && (n += sumWithConditions(n - 1)) > 0;
        return n;
    }
}
