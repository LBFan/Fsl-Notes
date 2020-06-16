package com.fan.interviewgold.cha17;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 马戏团人塔
 * 先根据身高 升序排序，若身高一样则根据体重 降序排序。
 * 身高排序好之后，剩余待处理的就是体重。
 * 处理体重的问题就是处理最长递增子序列的问题。
 * @date : 2020/04/09.
 */

public class Eight {
    public static int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; i++) {
            person[i] = new int[]{height[i], weight[i]};
        }
        // 先根据身高 升序排序，若身高一样则根据体重 降序排序。
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int[] pair : person) {
            // 二分查找
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = pair[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {65, 70, 56, 75, 60, 68};
        int[] weight = {100, 150, 90, 190, 95, 110};
        int bestSeqAtIndex = bestSeqAtIndex(height, weight);
        System.out.println(bestSeqAtIndex);
    }
}

