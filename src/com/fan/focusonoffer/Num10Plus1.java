package com.fan.focusonoffer;

import java.util.ArrayList;

/**
 * @author :  PF_23
 * @Description : 斐波那契数列
 * 求斐波那契数列的第 n 项，n <= 39。
 * 由于待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，之后就能以 O(1) 时间复杂度得到第 n 项的值。
 * @date : 2019/12/12.
 */

public class Num10Plus1 {
    private int[] fib = new int[40];

    public Num10Plus1() {
        fib[1] = 1;
        fib[2] = 1;
        int pre1 = 1, pre2 = 1;
        for (int i = 3; i <= 40; i++) {
            fib[i] = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib[i];
        }
    }


    public int Fibonacci(int n) {
        return fib[n];
    }
}

