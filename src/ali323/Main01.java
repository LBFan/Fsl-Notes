package ali323;

import java.util.Scanner;

/**
 * 作者：点点滴滴尽入我心
 * 链接：https://www.nowcoder.com/discuss/389778
 * 来源：牛客网
 * <p>
 * 从n个人中选择任意数量的人员组成一支队伍，然后从一支队伍中选出一位队长，不同的队长算不同的组合，问这样的组合的数量对10^9+7取模 。
 * <p>
 * 1
 * 数据范围：1 <= n <= 1000000000;
 * 示例
 * <p>
 * 1
 * 2
 * 3
 * 输入：n = 2
 * 输出：4
 * 解释,(1),(2)(1,2),(2,1)四种，括号第一个为队长
 * <p>
 * 小知识：介绍一个解决找规律问题的好网站OEIS（ 在线整数数列查询网站 http://oeis.org/ ）
 * <p>
 * 数学知识告诉我们，res的通项公式为：
 * res = n* 2^{n-1}
 * <p>
 * 要求2^n - 1，O(logN)复杂度，经典的快速幂算法。
 */
public class Main01 {
    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println((pow(n - 1) * n) % mod);
    }

    /**
     * 要求2^n - 1，O(logN)复杂度，经典的快速幂算法。
     *
     * @param n
     * @return
     */
    public static long pow(int n) {
        if (n == 0) {
            return 1;
        }
        long half = pow(n / 2);
        if (n % 2 == 0) {
            return (half * half) % mod;
        } else {
            return (half * half * 2) % mod;
        }
    }
}