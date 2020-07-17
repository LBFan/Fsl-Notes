package com.fan.exam.jianzhioffer;

/**
 * @Description : 1~n整数中1出现的次数 TODO 看看是如何计算出来的 n为几位数就统计几轮
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num43 {
    public static int numberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }
}
