package com.fan.focusoffer2.weekexam.week2;

import java.sql.RowId;

/**
 * @author : PF_23
 * @Description : 二维子矩阵的数字之和
 * @date : 2022/3/12 09:33.
 */

public class Num13 {

    /**
     * 表示原矩阵的每一个从左上角到右下角的子矩阵的和
     */
    private int[][] sums;

    private void sumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        // 计算每一个子矩阵的和，找规律：如何快速的求出sums[i][j]:
        // 可以单独计算最后一行的累计和rowSum,那么sums[i][j] = rowSum + sums[i - 1][j]
        // 为了便于计算，分别增加一行一列作为辅助，使得不用去判断当前子矩阵是否在边上
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i <= matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j <= matrix[0].length; j++) {
                // 第一行和第一列都是辅助数据，值都为0，所以0，0下标的矩阵和应该为sums[1,1]
                rowSum += matrix[i][j];
                sums[i + 1][j] = sums[i][j] + rowSum;
            }
        }
    }
    public int subSumOfMatrix(int[][] matrix, int row1, int col1, int row2, int col2) {
        sumMatrix(matrix);
        return sums[row2 + 1][col2 + 1] -  sums[row1 + 1][col2 + 1] -sums[row2 + 1][col1 + 1] + sums[row1 + 1][col1 + 1];
    }

    public static void main(String[] args) {

    }

}

