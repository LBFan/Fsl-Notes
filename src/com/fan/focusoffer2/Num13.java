package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/9 23:06.
 */

public class Num13 {
    /**
     * 二维子矩阵的数字之和
     * 为了减少重复计算，需要将每一个子矩阵的和求出来，后面不管求什么子矩阵，都可以在O(1)的时间复杂度内计算得出
     */

    private int[][] sums;

    /**
     * 构造子矩阵之和，每个位置的值就是从左上角到当前位置的字矩阵的和，好好体会一下。不是累计的和，是左上角0，0 到当前下标i，j的矩阵的和
     *
     * @return
     */
    public void subMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        //
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }


    public int subRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
    }

}

