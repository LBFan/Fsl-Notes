package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 求矩阵的幂积
 * @date : 2020/03/21.
 */

public class MatrixPowerUtil {

    /**
     * 矩阵m的p次方
     *
     * @param m
     * @param p
     * @return
     */
    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        // 先把res设置为单位矩阵，相当于整数中的1
        for (int i = 0; i < res.length; i++) {
            /**
             *  1 0
             *  0 1
             */
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            // 当当前二进制的位 == 1时，累乘
            if ((p & 1) != 0) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
        }
        return res;
    }

    /**
     * 求矩阵m1和m2的乘积
     *
     * @param m1
     * @param m2
     * @return
     */
    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }

        }
        return res;
    }


}

