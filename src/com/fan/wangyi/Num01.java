package com.fan.wangyi;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description : 素数个数 AC
 * 思路： 贪心，一直拆成2，最终由多个2和最多一个三组成
 * @Author : shulin.fan
 * @Date : 2020/8/8
 */
public class Num01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        long sum = sum(nums);
        System.out.println(sum);
    }

    private static long sum(int[] nums) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 2) {
                continue;
            } else {
                count += (nums[i] / 2);
            }
        }
        return count;
    }
}
