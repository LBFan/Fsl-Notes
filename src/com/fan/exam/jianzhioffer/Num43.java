package com.fan.exam.jianzhioffer;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description : 1~n整数中1出现的次数 TODO 看看是如何计算出来的 n为几位数就统计几轮
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num43 {
    public static int numberOf1Between1AndN_Solution(int n) {
        //int cnt = 0;
        //for (long m = 1; m <= n; m *= 10) {
        //    long a = n / m, b = n % m;
        //    cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        //}
        //return cnt;

        // 思路：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
        int high = n / 10, cur = n % 10, digit = 1, low = 0;
        int res = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit = digit * 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2048;
        int i = numberOf1Between1AndN_Solution(n);
        System.out.println(i);
    }
}
