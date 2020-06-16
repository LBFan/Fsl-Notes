package com.fan.baidu;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : AC
 * @date : 2020/03/29.
 */

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = n, b = n - 1;
        long res = lcm(a, b) - gcd(a, b);
        System.out.println(res);

    }

    /**
     * 最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}

