package com.fan.leetcode.arrs;

/**
 * @author :  PF_23
 * @Description : 改变矩阵维度
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * <p>
 * Output:
 * [[1,2,3,4]]
 * <p>
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
 * fill it row by row by using the previous list.
 * @date : 2020/02/25.
 */

public class Num02 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] reShape = new int[r][c];
        int idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reShape[i][j] = nums[i / n][i % n];
                idx++;
            }
        }
        return reShape;
    }
}

