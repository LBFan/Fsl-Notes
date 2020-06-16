package com.fan.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 最大连续子序列期望
 * @date : 2020/03/30.
 */

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 求出所有的连续子序列
        List<List<Integer>> res = getSubArray(nums);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            for (int j = 0; j < list.size(); j++) {
                max = Math.max(max, list.get(j));
            }
            sum += max;
            max = 0;
        }
        double result = (0.0 + sum) / res.size();
        System.out.printf("%.6f", result);
        // 从长度为1到长度为n的所有连续子序列
        // 累计所有子序列的最大值的和 （找出每一个子序列的最大值）
    }

    private static List<List<Integer>> getSubArray(int[] nums) {
        List<List<Integer>> bList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> tmp = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    tmp.add(nums[k]);
                }
                bList.add(tmp);
            }
        }
        return bList;
    }
}

