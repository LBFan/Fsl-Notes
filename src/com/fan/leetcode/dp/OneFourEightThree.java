package com.fan.leetcode.dp;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/21
 */
public class OneFourEightThree {
    int[][] dp;

    public OneFourEightThree(int n, int[] parent) {
        // dp[i][j] 表示节点i的第2^j代祖先。
        // j = 0，就是父亲。
        dp = new int[n + 5][20];
        // dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            // 为什么要+1？因为否则会出现-1的索引，那样数组索引就会报错。
            // 注意dp[i]存储的是第i-1的祖宗节点
            dp[i][0] = parent[i - 1] + 1;
        }
        for (int j = 1; j < 20; j++) {
            for (int i = 0; i <= n; i++) {
                dp[i][j] = dp[dp[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int res = node + 1;
        for (int i = 0; i < 20; i++) {
            // 测试了两种方法，都可以
            // if(((k >> i) & 1) > 0){
            //     res = dp[res][i];

            // }
            if (((1 << i) & k) > 0) {
                res = dp[res][i];

            }
        }
        return res - 1;

    }
}
