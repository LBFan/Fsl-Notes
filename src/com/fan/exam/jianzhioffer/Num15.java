package com.fan.exam.jianzhioffer;

/**
 * @Description : 位运算 二进制中1的个数
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num15 {
    public static int countOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 7;
        int one = countOne(n);
        System.out.println(one);
    }
}
