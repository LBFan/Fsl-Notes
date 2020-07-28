package com.fan.leetcode.top100.hard;

/**
 * @author : PF_23
 * @Description : 戳气球
 * @date : 2020/07/27.
 */

public class ThreeOneTwo {
    /**
     * rec[i][j]: i ~j 区间的最大结果
     *
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            val[i + 1] = nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

    /**
     * 更易理解
     *
     * @param nums 数组
     * @return 最大结果
     */
    public static int maxCoinsEasy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] help = new int[n + 2];
        help[0] = help[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            help[i + 1] = nums[i];
        }
        return process(help, 1, n);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l - 1] * arr[l] * arr[r + 1];
        }
        // 最后打爆arr[L]的方案和最后打爆arr[R]的方案，先比较一下
        int max = Math.max(arr[l - 1] * arr[l] * arr[r + 1] + process(arr, l + 1, r), arr[l - 1] * arr[r] * arr[r + 1] + process(arr, l, r - 1));
        // 尝试中间位置最后打爆的方案
        for (int i = l + 1; i < r; i++) {
            max = Math.max(max, arr[l - 1] * arr[i] * arr[r + 1] + process(arr, l, i - 1) + process(arr, i + 1, r));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int maxCoins = maxCoinsEasy(nums);
        System.out.println(maxCoins);
    }
}

