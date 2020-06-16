package com.fan.interviewgold.cha08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/04/09.
 */

public class Two {

    private int m;
    private int n;
    private int[][] grid;

    public List<List<Integer>> pathWithObstacles(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        List<List<Integer>> ansList = new ArrayList<>();
        dfs(0, 0, new boolean[m][n], ansList);
        return ansList;
    }

    private boolean dfs(int row, int col, boolean[][] visited, List<List<Integer>> pathList) {
        if (row >= m || col >= n || grid[row][col] == 1 || visited[row][col]) {
            return false;
        }

        pathList.add(Arrays.asList(row, col));
        if (row == m - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;

        if (dfs(row + 1, col, visited, pathList) || dfs(row, col + 1, visited, pathList)) {
            return true;
        }

        pathList.remove(pathList.size() - 1);
        return false;
    }
}

