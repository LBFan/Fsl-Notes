package com.fan.leetcode.arrs;

/**
 * @author :  PF_23
 * @Description : 找出数组中最长的连续 1
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * @date : 2020/02/25.
 */

public class Num03 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int num : nums) {
            cur = (num == 0) ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}

