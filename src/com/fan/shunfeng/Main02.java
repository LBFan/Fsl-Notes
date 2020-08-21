package com.fan.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description : 赏金猎人
 * 最大收益
 * @Author : shulin.fan
 * @Date : 2020/8/21
 */
public class Main02 {
    /**
     * 排序+动态规划
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] task = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                task[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(task, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] != o2[1] ? o1[1] - o2[1] : o2[2] - o1[2]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = task[i][2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (task[j][1] <= task[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + task[i][2]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
