package leetcode.dp.fibo;

/**
 * @author :  PF_23
 * @Description : 爬楼梯
 * 题目描述：有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
 * @date : 2020/01/06.
 */

public class Num01 {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int pre2 = 1, pre1 = 2;
        int cur;
        for (int i = 3; i <= n; ++i) {
            cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args) {
        int n = 5;
        int climbStairs = new Num01().climbStairs(n);
        System.out.println(climbStairs);
    }
}

