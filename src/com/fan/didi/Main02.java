package com.fan.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description : 几个岛
 * @Author : shulin.fan
 * @Date : 2020/8/21
 */
public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int count = 0;
            int[][] island = new int[m][n];
            int[][] num = new int[k][2];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                num[i][0] = sc.nextInt();
                num[i][1] = sc.nextInt();
            }
            for (int i = 0; i < k; i++) {
                int a = num[i][0];
                int b = num[i][1];
                if (a < 0 || b < 0 || a >= m || b >= n) {
                    list.add(count);
                    continue;
                }
                if (island[a][b] == 1) {
                    list.add(count);
                    continue;
                }
                island[a][b] = 1;
                if (a - 1 >= 0 && island[a - 1][b] == 1) {
                    if (count != 0) {
                        count--;
                    }
                }
                if (a + 1 < m && island[a + 1][b] == 1) {
                    if (count != 0) {
                        count--;
                    }
                }
                if (b - 1 >= 0 && island[a][b - 1] == 1) {
                    if (count != 0) {
                        count--;
                    }
                }
                if (b + 1 > n && island[a][b + 1] == 1) {
                    if (count != 0) {
                        count--;
                    }
                }
                count++;
                list.add(count);
            }
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.print(list.get(list.size() - 1));
            System.out.println();
        }

    }
}
