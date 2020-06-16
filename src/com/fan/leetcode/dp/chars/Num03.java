package com.fan.leetcode.dp.chars;

/**
 * @author :  PF_23
 * @Description : 复制粘贴字符
 * <p>
 * 题目描述：最开始只有一个字符 A，问需要多少次操作能够得到 n 个字符 A，每次操作可以复制当前所有的字符，或者粘贴。
 * <p>
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * @date : 2020/01/14.
 */

public class Num03 {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i + minSteps(n / i);
            }
        }
        return n;
    }

    public int minStepsByDP(int n) {
        int[] dp = new int[n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * 将所有操作分成以 copy 为首的多组，形如 (copy, paste, ..., paste)，再使用 C 代表 copy，P 代表 paste。例如操作 CPPCPPPPCP 可以分为 [CPP][CPPPP][CP] 三组。
     * 假设每组的长度为 g_1, g_2, ...。完成第一组操作后，字符串有 g_1 个 A，完成第二组操作后字符串有 g_1 * g_2 个 A。当完成所有操作时，共有 g_1 * g_2 * ... * g_n 个 'A'。
     * 我们最终想要 N = g_1 * g_2 * ... * g_n 个 A。如果 g_i 是合数，存在 g_i = p * q，那么这组操作可以分解为两组，第一组包含 1 个 C 和 p-1 个 P，第二组包含 1 个 C 和 q-1 个 P。
     * 现在证明这种分割方式使用的操作最少。原本需要 pq 步操作，分解后需要 p+q 步。因为 p+q <= pq，等价于 1 <= (p-1)(q-1)，当 p >= 2 且 q >= 2 时上式永远成立。
     * <p>
     * 算法
     * 假设 g_1, g_2, ... 就是 N 的素数分解，则需要的最少操作等于这些素数之和。
     *
     * @param n
     * @return
     */
    private int minStepsByMath(int n) {
//        int ans = 0, d = 2;
//        while (n > 1) {
//            while (n % d == 0) {
//                ans += d;
//                n /= d;
//            }
//            d++;
//        }
//        return ans;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}

