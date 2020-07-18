package com.fan.exam.jianzhioffer;

/**
 * @Description : 和为 S 的两个数字
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num57 {
    public static int[] findNumbersWithSum(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[2];
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int tmp = nums[l] + nums[h];
            if (tmp < sum) {
                l++;
            } else if (tmp > sum) {
                h--;
            } else {
                res[0] = l;
                res[1] = h;
                return res;
            }
        }
        return null;
    }
}
