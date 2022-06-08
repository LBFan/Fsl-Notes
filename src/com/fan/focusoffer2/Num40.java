package com.fan.focusoffer2;

import static com.fan.focusoffer2.Num39.extracted;

/**
 * @author : PF_23
 * @Description : 矩阵中的最大矩形
 * @date : 2022/3/23 22:03.
 */

public class Num40 {

    /**
     * 利用上一题思想：每一行变偶下来看做是一个直方图，构造每一行对应的直方图，当前值开始计算高度
     * 最终的最大矩阵就是每一行的最大矩阵的最大值
     *
     * @param matrix
     * @return
     */
    public int maxMatrix(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // 矩阵由多少列直方图就有多少个数字
        int[] heights = new int[matrix[0].length];
        int maxArea = -1;


        // 按行遍历每一行数
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                //针对每一行字符，遍历每一个字符，先判断当前字符是否为0，为0则当前列的高度为0，反之当前列的高度加一
                if (row[i] == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            // 每一行遍历完成后都要计算一下当前构造的直方图的最大面积
            maxArea = Math.max(maxArea, extracted(heights));
        }
        return maxArea;

    }
}

