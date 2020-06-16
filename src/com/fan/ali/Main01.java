package com.fan.ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 养鸡场
 * @date : 2020/03/30.
 */

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        int[] numsAfterM = numsAfterM(num, k, m);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numsAfterM[i];
        }
        System.out.println(sum);
    }

    /**
     * @param num
     * @param k 只
     * @param m 天
     * @return
     */
    private static int[] numsAfterM(int[] num, int k, int m) {
        int[] tmp = num.clone();
        for (int i = 0; i < m; i++) {
            Arrays.sort(tmp);
            for (int j = 0; j < tmp.length - 1; j++) {
                tmp[j] += k;
            }
            tmp[tmp.length - 1] /= 2;
        }
        return tmp;
    }
}

