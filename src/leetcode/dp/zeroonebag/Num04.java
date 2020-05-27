package leetcode.dp.zeroonebag;

/**
 * @author :  PF_23
 * @Description : 01 字符构成最多的字符串
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * <p>
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * <p>
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * <p>
 * Explanation: There are totally 4 strings can be formed by the using of 5 0s and 3 1s,
 * which are "10","0001","1","0"
 * 这是一个多维费用的 0-1 背包问题，有两个背包大小，0 的数量和 1 的数量。
 * @date : 2020/01/13.
 */

public class Num04 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        // 每个字符串只能用一次
        for (String s : strs) {
            int ones = 0, zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

