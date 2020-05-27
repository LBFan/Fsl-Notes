package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 正则表达式匹配
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，
 * 而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 * @date : 2019/12/23.
 */

public class Num19 {

    /**
     * TODO
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        // a* counts as single a
                        dp[i][j] |= dp[i][j - 1];
                        // a* counts as multiple a
                        dp[i][j] |= dp[i - 1][j];
                        // a* counts as empty
                        dp[i][j] |= dp[i][j - 2];
                    } else {
                        // a* only counts as empty
                        dp[i][j] = dp[i][j - 2];
                    }

        return dp[m][n];
    }
}

