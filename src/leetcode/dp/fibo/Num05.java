package leetcode.dp.fibo;

/**
 * @author :  PF_23
 * @Description : 母牛生产
 * 题目描述：
 * 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。
 * 每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量
 * 第 i 年牛的数量为：
 * dp[i] = dp[i - 1] + dp[i - 3]。
 * @date : 2020/01/06.
 */

public class Num05 {
    public int totalCows(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;dp[2] = 2;dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int totalCows = new Num05().totalCows(n);
        System.out.println(totalCows);
    }
}

