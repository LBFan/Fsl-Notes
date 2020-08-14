package com.fan.exam.jianzhioffer;

/**
 * @Description : 机器人的运动范围
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num13 {
    ///**
    // * 依次为左、右、上、下
    // */
    //private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    ///**
    // * 计数
    // */
    //private int cnt = 0;
    ///**
    // * 行数
    // */
    //private int rows;
    ///**
    // * 列数
    // */
    //private int cols;
    ///**
    // * 能走的最大数字（阈值）
    // */
    //private int threshold;
    //
    ///**
    // * 每个格子的数字之和
    // */
    //private int[][] digitSum;
    //
    //public int movingCount(int threshold, int rows, int cols) {
    //    this.rows = rows;
    //    this.cols = cols;
    //    this.threshold = threshold;
    //    boolean[][] hasUsed = new boolean[rows][cols];
    //    initDigitSum();
    //    dfs(hasUsed, 0, 0);
    //    return cnt;
    //}
    //
    //public static void main(String[] args) {
    //    Num13 num13 = new Num13();
    //    int count = num13.movingCount(6, 5, 6);
    //    System.out.println(count);
    //}
    //
    //private void dfs(boolean[][] hasUsed, int r, int c) {
    //    if (r < 0 || r >= rows || c < 0 || c >= cols || hasUsed[r][c]) {
    //        return;
    //    }
    //    hasUsed[r][c] = true;
    //    if (this.digitSum[r][c] > this.threshold) {
    //        return;
    //    }
    //    cnt++;
    //    for (int[] d : next) {
    //        dfs(hasUsed, r + d[0], c + d[1]);
    //    }
    //}
    //
    ///**
    // * 初始化每一个格子的数字之和
    // */
    //private void initDigitSum() {
    //    int[] initDigitSum = new int[Math.max(rows, cols)];
    //    for (int i = 0; i < initDigitSum.length; i++) {
    //        int n = i;
    //        while (n > 0) {
    //            initDigitSum[i] += n % 10;
    //            n /= 10;
    //        }
    //    }
    //    digitSum = new int[rows][cols];
    //    for (int i = 0; i < rows; i++) {
    //        for (int j = 0; j < cols; j++) {
    //            digitSum[i][j] = initDigitSum[i] + initDigitSum[j];
    //        }
    //    }
    //}

    int m, n, k;

    boolean[][] visited;

    /**
     * 大佬手法
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }


    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= 0 || visited[i][j] || k < (si + sj)) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
                dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}
