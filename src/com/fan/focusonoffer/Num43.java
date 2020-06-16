package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 从 1 到 n 整数中 1 出现的次数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * @date : 2019/12/27.
 */

public class Num43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
        /**
         * 举例501 511 521 说明问题：
         * ① 501在十位上：
         * 501十位 0 ，所以高位 5只能取0~4 ，此时十位才能取1，个位任意取0~9，共50种
         * ② 511在十位上：
         * 511 十位1，所以高位 5只能取0~4 ，此时十位才能取1，个位任意取0~9，共50种，另外当十位取1的时候，低位为1因此可以取到一个数字511，再加上原本的510，共52种。
         * ③ 521在十位上：
         * 521十位2，所以高位5可以取0~5，此时十位取1，个位任意取，共60种
         */
        //求每个位的数字所用
        //记录1的个数
        //由于high = n /(index*10) 中index *10 很容易越位
        //特修改如下
        //以下是计算的公式
    }

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        int n_solution = new Num43().NumberOf1Between1AndN_Solution(n);
        System.out.println(n_solution);
    }

    int countDigitOne(int n) {
        // TODO
        return 0;
    }

}

