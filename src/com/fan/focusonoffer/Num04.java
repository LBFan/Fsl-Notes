package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 二维数组中的查找
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * 时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数
 * @date : 2019/12/12.
 */

public class Num04 {
    public boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        // 从右上角开始
        int r = 0, c = cols - 1;
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}

