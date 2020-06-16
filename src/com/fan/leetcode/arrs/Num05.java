package com.fan.leetcode.arrs;

/**
 * @author :  PF_23
 * @Description : 有序矩阵的 Kth Element
 * matrix = [
 *   [ 1,  5,  9],
 *   [10, 11, 13],
 *   [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * @date : 2020/02/25.
 */

public class Num05 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length - 1;
        int lo = matrix[0][0], hi = matrix[m][n];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) {
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return lo;
    }


}

