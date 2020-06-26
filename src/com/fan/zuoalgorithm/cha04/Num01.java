package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 斐波那契
 * @date : 2020/03/20.
 */

public class Num01 {
    /**
     * O(2^N)
     *
     * @param n
     * @return
     */
    public int f1(int n) {

        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    /**
     * O(N)
     *
     * @param n
     * @return
     */
    public int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int p1 = 1;
        int p2 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = p1 + p2;
            p1 = p2;
            p2 = res;
        }
        return res;
    }

    public int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = MatrixPowerUtil.matrixPower(base, n - 2);
        return res[0][0] + res[0][1];
    }


}

