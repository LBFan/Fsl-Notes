package com.fan.leetcode.dp.arrayperiod;

/**
 * @author :  PF_23
 * @Description : 数组中等差递增子区间的个数
 * A = [0, 1, 2, 3, 4]
 * <p>
 * return: 6, for 3 arithmetic slices in A:
 * <p>
 * [0, 1, 2],
 * [1, 2, 3],
 * [0, 1, 2, 3],
 * [0, 1, 2, 3, 4],
 * [ 1, 2, 3, 4],
 * [2, 3, 4]
 * <p>
 * dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数。
 * 当 A[i] - A[i-1] == A[i-1] - A[i-2]，那么 [A[i-2], A[i-1], A[i]] 构成一个等差递增子区间。
 * 而且在以 A[i-1] 为结尾的递增子区间的后面再加上一个 A[i]，一样可以构成新的递增子区间。
 * <p>
 * dp[2] = 1
 * [0, 1, 2]
 * dp[3] = dp[2] + 1 = 2
 * [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
 * [1, 2, 3]     // 新的递增子区间
 * dp[4] = dp[3] + 1 = 3
 * [0, 1, 2, 3, 4], // [0, 1, 2, 3] 之后加一个 4
 * [1, 2, 3, 4],    // [1, 2, 3] 之后加一个 4
 * [2, 3, 4]        // 新的递增子区间
 * <p>
 * 在 A[i] - A[i-1] == A[i-1] - A[i-2] 时，dp[i] = dp[i-1] + 1。
 * 因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果。
 * @date : 2020/01/06.
 */

public class Num02 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i - 2] + A[i] == 2 * A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        // 递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果。
        int total = 0;
        for (int d : dp) {
            total += d;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int slices = new Num02().numberOfArithmeticSlices(nums);
        System.out.println(slices);
    }
}

