package com.fan.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description : 排列
 * @Author : shulin.fan
 * @Date : 2020/8/8
 */
public class Num02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < nums.length; i++) {
            int[] cos = new int[nums[i]];
            for (int j = 0; j < cos.length; j++) {
                cos[j] = in.nextInt();
            }
        }
        int[] res = new int[n];
        // 5 1 -> 23451  42 13425
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }



    }

    private static void swap(int[] res, int i, int j) {
        int t = res[i];
        res[i] = res[j];
        res[j] = t;
    }

    //private static long sum(int[] nums) {
    //    long count = 0;
    //    for (int i = 0; i < nums.length; i++) {
    //        if (nums[i] < 2) {
    //            continue;
    //        } else {
    //            count += (nums[i] / 2);
    //        }
    //    }
    //    return count;
    //}
}
