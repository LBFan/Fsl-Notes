package com.fan.exam.jianzhioffer;

/**
 * @Description : 不用加减乘除做加法
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num65 {
    public static int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }
}
