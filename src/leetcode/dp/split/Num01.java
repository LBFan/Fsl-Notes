package leetcode.dp.split;

/**
 * @author :  PF_23
 * @Description : 分割整数的最大乘积
 * 题目描述：
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * @date : 2020/01/06.
 */

public class Num01 {
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int threeTimes = n / 3;
        if (n % 3 == 1) {
            threeTimes--;
        }
        int timeOf2 = (n - 3 * threeTimes) / 2;
        return (int) (Math.pow(3, threeTimes) * Math.pow(2, timeOf2));
    }

    public int integerBreakByDp(int n) {
       int[] dp = new int[n + 1];
       dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}

