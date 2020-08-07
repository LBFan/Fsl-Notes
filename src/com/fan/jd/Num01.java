package com.fan.jd;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description : 数列求和
 * @Author : shulin.fan
 * @Date : 2020/8/6
 */
public class Num01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Double sum = getSum(n);
        System.out.printf("%.6f", sum);
    }

    private static Double getSum(int n) {
        if (n == 0) {
            return Double.valueOf(-1L);
        }
        Double[] dp = new Double[n + 1];
        dp[1] = 0.1;
        for (int i = 2; i <= n; i++) {
            BigDecimal b1 = new BigDecimal(Double.toString(1.0 / (10 * i * (2 * i - 1))));
            BigDecimal d = new BigDecimal(dp[i - 1]);
            dp[i] = d.add(b1).doubleValue();
        }
        return dp[n];
    }
}
