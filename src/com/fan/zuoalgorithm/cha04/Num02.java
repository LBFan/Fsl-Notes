package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 矩阵的最小路径和
 * @date : 2020/03/21.
 */

public class Num02 {

    public int minPathSum1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // dp[i][j]表示从（0，0） 到（i, j）位置的最小路径
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        // 第一列只能从上到下
//        for (int i = 1; i < row; i++) {
//            dp[0][i] += matrix[0][i];
//        }
//
//        // 第一行只能从左到右
//        for (int i = 1; i < col; i++) {
//            dp[i][0] += matrix[i][0];
//        }

        // 第一列只能从上到下
        for (int i = 1; i < row; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        // 第一行只能从左到右
        for (int i = 1; i < col; i++) {
            dp[i][0] += dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // 两种到达路径的最小值
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j]);
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 空间压缩技巧
     *
     * @param matrix
     * @return
     */
    public int minPathSum2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // more是行数和列数中更大的那个
        int more = Math.max(matrix.length, matrix[0].length);
        // less是行数和列数更小的那个
        int less = Math.min(matrix.length, matrix[0].length);
        // 行数是不是大于等于列数
        boolean rowmore = more == matrix.length;
        // 数组长度仅为行数和列数更小的那个 （空间压缩策略）
        int[] arr = new int[less];
        arr[0] = matrix[0][0];
        // 根据行数和列数谁更大更新第一行或者第一列的最小路径
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowmore ? matrix[0][i] : matrix[i][0]);
        }
        // 滚动更新每行或者每列的最小路径值
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? matrix[i][0] : matrix[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j - 1], arr[j]) + (rowmore ? matrix[i][j] : matrix[j][i]);
            }
        }
        return arr[less - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int pathSum2 = new Num02().minPathSum2(matrix);
        System.out.println(pathSum2);
    }
}

