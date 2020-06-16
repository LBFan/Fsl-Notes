package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 矩阵中的路径
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * <p>
 * 解题思路：
 * 使用回溯法（backtracking）进行求解，它是一种暴力搜索方法，通过搜索所有可能的结果来求解问题。
 * 回溯法在一次搜索结束时需要进行回溯（回退），将这一次搜索过程中设置的状态进行清除，从而开始一次新的搜索过程。
 * 例如下图示例中，从 f 开始，下一步有 4 种搜索可能，如果先搜索 b，需要将 b 标记为已经使用，防止重复使用。
 * 在这一次搜索结束之后，需要将 b 的已经使用状态清除，并搜索 c。
 * @date : 2019/12/17.
 */

public class Num12 {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == str.length) {
            return true;
        }
        // matrix[r][c] != str[pathLen] : 字符不匹配
        // marked[r][c] ： 已经标记过
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }
        marked[r][c] = true;
        // 遍历其上下左右位置的字符 递归查找
        for (int[] d : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + d[0], c + d[1])) {
                return true;
            }
        }
        // 循环完之后恢复为未标记
        marked[r][c] = false;
        // 没找到则返回false
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = array[idx++];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};
        char[] str = {'c', 'f'};
//        char[] str = {'b', 'f', 'c', 'e'};
        Num12 num12 = new Num12();
        boolean hasPath = num12.hasPath(arr, 3, 4, str);
        System.out.println(hasPath);
    }

}

