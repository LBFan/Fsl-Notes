package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 跳台阶
 * @date : 2020/03/21.
 */

public class Num01PlusOne {
    public int s1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        return s1(n - 1) + s1(n - 2);
    }

    /**
     * O(N)
     *
     * @param n
     * @return
     */
    public int s2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int pre1 = 1;
        int pre2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }

    /**
     * 利用矩阵乘积使得时间复杂度为O(logN)
     *
     * @param n
     * @return
     */
    public int s3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = MatrixPowerUtil.matrixPower(base, n - 2);
        return 2 * res[0][0] + res[1][0];
    }
}

