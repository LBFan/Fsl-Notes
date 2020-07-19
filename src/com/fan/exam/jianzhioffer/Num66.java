package com.fan.exam.jianzhioffer;

/**
 * @Description : 构建乘积数组
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num66 {
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            B[i] = product;
        }

        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }
}
