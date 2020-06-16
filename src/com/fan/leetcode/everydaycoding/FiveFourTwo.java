package com.fan.leetcode.everydaycoding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * @date : 2020/04/15.
 */

public class FiveFourTwo {

    private int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        // BFS
        //
        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[n][m];
        // 标记当前位置是否都看过
        boolean[][] visited = new boolean[n][m];

        // BFS 队列
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 将 0 全部放入队列
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0], y = top[1];
            // BFS 搜索四个方向
            for (int[] d : direct) {
                int newX = x + d[0];
                int newY = y + d[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY]) {
                    continue;
                }
                // 更新距离
                res[newX][newY] = res[x][y] + 1;
                visited[newX][newY] = true;
                // 新元素入队
                queue.add(new int[]{newX, newY});
            }
        }

        return res;
    }
}

