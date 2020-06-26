package com.fan.zuoalgorithm.cha04;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 最长递增子序列
 * @date : 2020/03/21.
 */

public class Num07 {

    /**
     * @param arr
     * @return
     */
    public int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j + 1]);
                }
            }
        }
        return dp;
    }

    public int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        // 找出最长的序列数
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];

        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    /**
     * 暴力法
     *
     * @param arr
     * @return
     */
    public int[] lis1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }

    public int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l, r, m;

        for (int i = 1; i < arr.length; i++) {
            // 每次遍历arr[i]时，ends有效区域的最左下标值始终为0
            l = 0;
            // 每次遍历arr[i]时，更新ends有效区域的最右下标值
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            // 更新ends有效区的右区间值
            right = Math.max(right, l);
            // 找到的l就是ends有效区中最左大于等于arr[i]的值得下标
            ends[l] = arr[i];
            // 当前arr[0..i]的最长递增区间的长度为 l + 1
            dp[i] = l + 1;
        }
        return dp;
    }

    public int[] lis2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] ints = new Num07().lis2(arr);
        System.out.println(Arrays.toString(ints));
    }
}

