package com.fan.exam.jianzhioffer;

/**
 * @Description : 矩阵中的路径
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num12 {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] chars) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, chars, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] chars, boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == chars.length) {
            return true;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != chars[pathLen] || marked[r][c]) {
            return false;
        }
        marked[r][c] = true;
        // 遍历其上下左右位置的字符 递归查找
        for (int[] d : next) {
            if (backtracking(matrix, chars, marked, pathLen + 1, r + d[0], c + d[1])) {
                return true;
            }
        }
        // 回溯：循环完之后恢复为未标记
        marked[r][c] = false;
        // 没找到则返回false
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0, index = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[index++];
            }
        }
        return matrix;
    }
}
