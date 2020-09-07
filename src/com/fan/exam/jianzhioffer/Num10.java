package com.fan.exam.jianzhioffer;

/**
 * @Description :fib
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num10 {
    private int[] fib = new int[40];

    public Num10() {
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

    /**
     * leetcode 大佬
     *
     * @param n n
     * @return fib
     */
    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        int fib = fib(5);
        System.out.println(fib);
    }
}
