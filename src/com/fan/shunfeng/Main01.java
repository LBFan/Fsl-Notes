package com.fan.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description : 服务器管理
 * 求服务器可能的最大租金
 * @Author : shulin.fan
 * @Date : 2020/8/20
 */
public class Main01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] window = new int[n];
        for (int i = 0; i < n; ++i) {
            window[i] = sc.nextInt();
        }
        int[][] needs = new int[m][2];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < 2; ++j) {
                needs[i][j] = sc.nextInt();
            }
        }
        int res = max(window, needs);
        System.out.println(res);
    }

    //private static int max(int[] window, int[][] needs) {
    //    Arrays.sort(needs, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
    //    Arrays.sort(window);
    //    int n = window.length;
    //    int m = needs.length;
    //    int res = 0;
    //    boolean[] visit = new boolean[m];
    //    for (int i = 0; i < n; i++) {
    //        int tmpMax = -1;
    //        for (int j = 0; j < m; j++) {
    //            if (visit[j]) {
    //                continue;
    //            }
    //
    //            if (needs[j][0] <= window[i]) {
    //                // 求出其中的最大值needs[j][1] ，并将visit[j] = true;
    //                tmpMax = Math.max(tmpMax, needs[j][1]);
    //            } else {
    //                break;
    //            }
    //        }
    //
    //        res += tmpMax;
    //        for (int k = 0; k < m; k++) {
    //            if (needs[k][1] == tmpMax) {
    //                visit[k] = true;
    //                break;
    //            }
    //        }
    //    }
    //    return res;
    //}

    private static int max(int[] window, int[][] needs) {
        Arrays.sort(needs, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        Arrays.sort(window);
        int n = window.length;
        int m = needs.length;
        int res = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            int tmpMax = 0;
            int index = 0;
            for (int j = 0; j < m; j++) {
                if (needs[j][0] <= window[i]) {
                    flag = 1;
                    if (needs[j][1] >= tmpMax) {
                        index = j;
                        tmpMax = needs[j][1];
                    } else {
                        break;
                    }
                }
            }
            res += tmpMax;
            if (flag == 1) {
                needs[index][1] = 0;
            }
        }
        return res;
    }
}
