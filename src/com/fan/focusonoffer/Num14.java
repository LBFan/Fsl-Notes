package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 剪绳子
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 * 1.贪心
 * 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。
 * 如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。
 * <p>
 * 证明：当 n >= 5 时，3(n - 3) - n = 2n - 9 > 0，且 2(n - 2) - n = n - 4 > 0。
 * 因此在 n >= 5 的情况下，将绳子剪成一段为 2 或者 3，得到的乘积会更大。
 * 又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，所以剪成一段长度为 3 比长度为 2 得到的乘积更大。
 * <p>
 * 2. DP
 * @date : 2019/12/18.
 */

public class Num14 {
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
//        int twoTimes = (n - threeTimes *3) / 2;
        return (int) (Math.pow(3, threeTimes) * 4);
//        return (int) (Math.pow(3, threeTimes) * Math.pow(2, twoTimes));
    }

    public static int integerBreakByDp(int n) {
        int[] dp = new int[n + 1];
        // 长度为1的时候的乘积
        dp[1] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 长度为i时剪绳子的最大乘积
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }

    /**
     * 贪心策略：大数时使用本方法
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int mod = (int) (1e9 + 7);
        int res = 1;
        while (n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        int n = 10;
        int i = new Num14().integerBreak(n);
        int breakByDp = integerBreakByDp(n);
        System.out.println(breakByDp);
        System.out.println(i);
    }
}

