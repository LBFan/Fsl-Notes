package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 母牛生产问题
 * 母牛永远不会死
 * @date : 2020/03/21.
 */

public class Num01PlusTwo {
    public int c1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 3) {
            return n;
        }
        return c1(n - 1) + c1(n - 3);
    }

    public int c2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 3) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        int res = 3;
        // 两个临时变量用来存储pre1和pre2
        int tmp1;
        int tmp2;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre2;
            res = res + pre1;
            pre2 = tmp1;
            pre1 = tmp2;
        }
        return res;
    }

    public int c3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 3) {
            return n;
        }

        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] res = MatrixPowerUtil.matrixPower(base, n - 3);
        // C(n) = （3，2，1）x res的第一个数，即矩阵（3，2，1）的第一行乘以矩阵res的第一列
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }


    public static void main(String[] args) {
        int n = 9;
        int c2 = new Num01PlusTwo().c3(n);
        System.out.println(c2);
    }
}

