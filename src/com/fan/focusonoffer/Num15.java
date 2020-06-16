package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 二进制中1的个数
 * 考察点：位运算
 * @date : 2019/12/18.
 */

public class Num15 {
    public static int numberOfOne(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= (num - 1);
        }
        return count;
//        return Integer.bitCount(num);
    }

    public static void main(String[] args) {
        int num = 9;
        int i = numberOfOne(num);
        System.out.println(i);
    }
}

