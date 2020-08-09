package com.fan.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description : 丢物品最少，使其两人分的相同
 * @Author : shulin.fan
 * @Date : 2020/8/8
 */
public class Num03 {
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

            // 对每一个cos计算输出
            // 对每一个cos计算输出

            int res = res(cos);
            System.out.println(res);

        }

    }

    private static int res(int[] cos) {
        int result = 0;
        int sum = 0;
        for (int c : cos) {
            sum += c;
        }

        Arrays.sort(cos);
        int half = sum / 2;
        int l = 0, r = cos.length - 1;
        int tempSum = 0;
        while (l < r) {
            tempSum += cos[l] + cos[r];
            if (tempSum > half) {
                result += cos[l];
            } else {
                l++;
            }
        }
        return result;
    }
}
