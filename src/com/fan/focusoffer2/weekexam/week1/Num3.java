package com.fan.focusoffer2.weekexam.week1;

/**
 * @author : PF_23
 * @Description : 前n个数字二进制形式中1的个数
 * @date : 2022/3/5 11:22.
 */

public class Num3 {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j != 0) {
                j &= (j - 1);
                res[i]++;
            }
        }

        return res;
    }

    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;
    }


    public int[] countBits3(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }
}

