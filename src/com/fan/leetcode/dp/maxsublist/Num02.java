package com.fan.leetcode.dp.maxsublist;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 一组整数对能够构成的最长链
 * 题目描述：对于 (a, b) 和 (c, d) ，如果 b < c，则它们可以构成一条链。
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * @date : 2020/01/07.
 */

public class Num02 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ret = 1;
        for (int dd : dp) {
            ret = Math.max(ret, dd);
        }
        return ret;
    }
}

