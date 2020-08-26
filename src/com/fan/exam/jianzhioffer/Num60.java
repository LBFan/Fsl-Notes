package com.fan.exam.jianzhioffer;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description : n 个骰子的点数 好好想想过程
 * 把 n 个骰子扔在地上，求点数和为 s 的概率
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num60 {
    /**
     * 使用一个二维数组 dp 存储点数出现的次数，其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数。
     * <p>
     * 空间复杂度：O(N2)
     *
     * @param n 骰子数
     * @return 集合
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++)
            /* 使用 i 个骰子最小点数为 i */ {
            for (int j = i; j <= pointNum; j++) {
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }

        return ret;
    }

    /**
     * 动态规划 + 旋转数组
     * 空间复杂度：O(N)
     *
     * @param n 骰子数
     * @return 集合
     */
    public List<Map.Entry<Integer, Double>> dicesSum02(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[2][pointNum + 1];

        for (int i = 1; i <= face; i++) {
            dp[0][i] = 1;
        }
        /* 旋转标记 */
        int flag = 1;
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 0; j <= pointNum; j++)
                /* 旋转数组清零 */ {
                dp[flag][j] = 0;
            }

            for (int j = i; j <= pointNum; j++) {
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[flag][j] += dp[1 - flag][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));
        }

        return ret;
    }

    /**
     * 大神解法
     *
     * @param n
     * @return
     */
    public double[] twoSum(int n) {
        double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int x = 0; x < 6; x++) {
                    tmp[j + x] += pre[j] / 6;
                }
            }
            pre = tmp;
        }
        return pre;
    }
}
