package com.fan.didi;

import java.util.Scanner;

/**
 * @Description : 斐波那契蛇 AC
 * @Author : shulin.fan
 * @Date : 2020/8/21
 */
public class Main202002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("");
        } else if (n == 1) {
            System.out.println(1);
        } else {
            long[][] res = new long[n][n];
            int s = n * n;
            long[] dp = new long[s];
            dp[0] = 1; dp[1] = 1;
            for (int i = 2; i < s; ++i) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            int r = 0, rows = n - 1, c = 0, cols = n - 1;
            int index = s - 1;
            while ((r <= rows || c <= cols) && index >= 0) {
                // 左 -> 右
                if (r <= rows) {
                    for (int i = c; i <= cols; i++) {
                        res[r][i] = dp[index--];
                    }
                    r++;
                }
                // 上 -> 下
                if (c <= cols) {
                    for (int i = r; i <= rows; i++) {
                        res[i][cols] = dp[index--];
                    }
                    cols--;
                }
                if (r <= rows) {
                    for (int i = cols; i >= c; i--) {
                        res[rows][i] = dp[index--];
                    }
                    rows--;
                }
                if (c <= cols) {
                    for (int i = rows; i >= r; i--) {
                        res[i][c] = dp[index--];
                    }
                    c++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

}
