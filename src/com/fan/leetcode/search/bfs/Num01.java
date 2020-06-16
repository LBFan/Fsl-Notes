package com.fan.leetcode.search.bfs;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 计算在网格中从原点到特定点的最短路径长度 二进制矩阵中的最短路径
 * <p>
 * [[1,1,0,1],
 * [1,0,1,0],
 * [1,1,1,1],
 * [1,0,1,1]]
 * 题目描述：0 表示可以经过某个位置，求解从左上角到右下角的最短路径长度。
 * @date : 2020/02/21.
 */

public class Num01 {
    public int shortestPathBinaryMatrix(int[][] grids) {
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                // 标记
                grids[cr][cc] = 1;
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 1) {
                        continue;
                    }
                    if (nr == m - 1 && nc == n - 1) {
                        return pathLength++;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}

