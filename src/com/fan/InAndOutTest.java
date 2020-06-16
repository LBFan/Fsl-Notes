package com.fan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/26.
 */

public class InAndOutTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        // 输入两行数字，第一行两个n, m
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arrN = new int[n][1];
        for (int i = 0; i < n; i++) {
            arrN[i][0] = sc.nextInt();
        }
        int[][] arrM = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                arrM[i][j] = sc.nextInt();
            }
        }

//        System.out.println(Arrays.deepToString(arrN));
//        System.out.println(Arrays.deepToString(arrM));
//        // 对操作2、3求出结果， 每求出一个值，换行打印出来
//        System.out.println("=============================");
        for (int i = 0; i < m; i++) {
            if (arrM[i][0] == 2) {
                // 求连续和
                // 1. 取出起始位置
                int start = arrM[i][1];
                // 2. 取出终止位置
                int end = arrM[i][2];
                // 求和
                int sum = 0;
                for (int j = start - 1; j < end; j++) {
                    sum += arrN[j][0];
                }
                System.out.println(sum);
            } else if (arrM[i][0] == 3) {
                // 求最大值
                // 1. 取出起始位置
                int start = arrM[i][1];
                // 2. 取出终止位置
                int end = arrM[i][2];
                // 求和
                int max = 0;
                for (int j = start - 1; j < end; j++) {
                    max = Math.max(max, arrN[j][0]);
                }
                System.out.println(max);
            }

        }

//        int[][] arr = new int[n][m];
//        p = sc.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        int[][] find = new int[p][2];
//        for (int i = 0; i < p; i++) {
//            for (int j = 0; j < 2; j++) {
//                find[i][j] = sc.nextInt();
//            }
//        }



    }
}

