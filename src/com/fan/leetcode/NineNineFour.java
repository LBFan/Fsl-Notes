package com.fan.leetcode;

class NineNineFour {
    //grid中的值可以表示橘子的腐烂值，大于等于2都算腐烂
    // 初始橘子腐烂值为2，过一回合被传播的橘子的腐烂值+1，传播越远，时间越久，最外层的腐烂值就越大，
    // 题目结果就等于最大腐烂值-2

    public int orangesRotting(int[][] grid) {
        boolean has2 = false;
        for (int i = 0; i < grid.length; i++) {
            //第一次遍历，对每个初始腐烂橘子进行dfs
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    has2 = true;
                    dfs(grid, i, j, 2);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            //第二次遍历，找出最大腐烂值，如果有新鲜橘子直接返回-1
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                res = Math.max(res, grid[i][j]);
            }
        }

        if (!has2) {
            return 0;
        }
        return res - 2;
    }

    private void dfs(int[][] grid, int x, int y, int val) {
        //val表示腐烂值，每传播一层的腐烂值加1
        //是新鲜橘子直接腐烂，如果之前已经腐烂但这次腐烂的距离更近（val更小），重新赋腐烂值
        grid[x][y] = val;
        if (x < grid.length - 1 && (grid[x + 1][y] == 1 || grid[x + 1][y] > val + 1)) {
            dfs(grid, x + 1, y, val + 1);
        }
        if (x >= 1 && (grid[x - 1][y] == 1 || grid[x - 1][y] > val + 1)) {
            dfs(grid, x - 1, y, val + 1);
        }
        if (y < grid[0].length - 1 && (grid[x][y + 1] == 1 || grid[x][y + 1] > val + 1)) {
            dfs(grid, x, y + 1, val + 1);
        }
        if (y >= 1 && (grid[x][y - 1] == 1 || grid[x][y - 1] > val + 1)) {
            dfs(grid, x, y - 1, val + 1);
        }
    }
}