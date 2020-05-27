package interviewgold.cha08;

/**
 * @author :  PF_23
 * @Description : 三步问题
 * @date : 2020/04/07.
 */

public class One {

    public static int waysToStep01(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        long p1 = 1;
        long p2 = 2;
        long p3 = 4;
        long res = 0;
        for (int i = 3; i < n; i++) {
            res = (p1 + p2 + p3) % 1000000007;
            p1 = p2 % 1000000007;
            p2 = p3 % 1000000007;
            p3 = res % 1000000007;
        }
        return (int) (res % 1000000007);

//        if (n <= 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        long[] dp = new long[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 4;
//        for (int i = 4; i <= n; i++) {
//            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
//        }
//
//        return (int) dp[n];
    }

    /**
     * 更优解
     */
    static final int MOD = 1000000007;

    static int add(int a, int b) {
        if ((a += b) >= MOD) {
            a -= MOD;
        }
        return a;
    }

    public static int waysToStep02(int n) {
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 0; i < n; i++) {
            int d = add(add(a, b), c);
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 1000000;
        int waysToStep = waysToStep02(n);
        System.out.println(waysToStep);
    }
}

