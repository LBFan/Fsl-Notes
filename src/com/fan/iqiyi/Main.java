package com.fan.iqiyi;

import java.util.Scanner;

/**
 * @Description : n的阶乘问题
 * 题目描述：
 * 正整数n的阶乘(n!)中的末尾有多少个0?
 * <p>
 * 例如：n = 5, n! = 120.末尾有1个0
 * <p>
 * 实现：int CountZero(int n);
 * @Author : shulin.fan
 * @Date : 2020/8/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int countZero = countZero(n);
        System.out.println(countZero);
    }

    private static int countZero(int n) {
        int zeroCount = 0;
        //long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
