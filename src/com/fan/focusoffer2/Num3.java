package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/3 22:05.
 */

public class Num3 {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = i;
            int count = 0;
            while (j != 0) {
                count++;
                j &= (j - 1);
            }
            res[i] = count;
        }

        return res;
    }

    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;

    }

    public int[] countBits3(int n) {
        int[] res = new int[n + 1];
        // 利用位运算右移一位与当前值中1的个数的区别
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Num3 num3 = new Num3();
        int n = 5;
        int[] countBits = num3.countBits(n);
        System.out.println("method1 :");
        for (int countBit : countBits) {
            System.out.println(countBit);
        }
        int[] countBits2 = num3.countBits2(n);
        System.out.println("method1 :");

        for (int countBit : countBits) {
            System.out.println(countBit);
        }
        int[] countBits3 = num3.countBits3(n);
        System.out.println("method1 :");

        for (int countBit : countBits) {
            System.out.println(countBit);
        }
    }
}

