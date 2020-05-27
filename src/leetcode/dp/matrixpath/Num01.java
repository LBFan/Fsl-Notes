package leetcode.dp.matrixpath;

/**
 * @author :  PF_23
 * @Description : 矩阵的最小路径和
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * 题目描述：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
 * @date : 2020/01/06.
 */

public class Num01 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int[] dp = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    // 只能从上侧走到该位置
                    dp[j] = dp[j];
                } else if (i == 0) {
                    // 只能从左侧走到该位置
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[cols - 1];
    }

}

