package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 机器人达到指定位置的方法数
 * @date : 2020/03/21.
 */

public class Num04 {
    /**
     * 暴力递归法
     *
     * @param N    : 位置1~N, 固定参数
     * @param cur  机器人当前位置， 可变参数
     * @param rest 还剩rest步没走，可变参数
     * @param p    最终目标位置p,固定参数
     * @return
     */
    public int walk(int N, int cur, int rest, int p) {
        if (rest == 0) {
            // 走完时当前位置是否在目标位置上，是则之前的移动是有效的记为1，否则无效记为0
            return cur == p ? 1 : 0;
        }
        if (cur == 1) {
            return walk(N, 2, rest - 1, p);
        }

        if (cur == N) {
            return walk(N, N - 1, rest - 1, p);
        }
        return walk(N, cur + 1, rest - 1, p) + walk(N, cur - 1, rest - 1, p);
    }

    /**
     * 主方法
     *
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    public int ways1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }

    /**
     * 动态规划
     *
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    public int ways2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        // 建立一张表
        int[][] dp = new int[K + 1][N + 1];
        // 初始化第一行, 其他的都为0
        dp[0][P] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                } else if (j > 1 && j < N) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j + 1];
                }
            }
        }
        return dp[K][M];

    }

    /**
     * 动态规划 + 压缩空间
     *
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    public int ways3(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[P] = 1;
        for (int i = 1; i <= K; ++i) {
            // 左上角的值:每次更新一行的值得时候都要更新左上角的值为dp[1]
            int leftUp = dp[1];
            for (int j = 1; j <= N; j++) {
                int tmp = dp[j];
                if (j == 1) {
                    dp[j] = dp[j + 1];
                } else if (j == N) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = leftUp + dp[j + 1];
                }
                leftUp = tmp;
            }
        }
        return dp[M];
    }
}

