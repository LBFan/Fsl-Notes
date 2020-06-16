package com.fan.leetcode.doublelink;

/**
 * @author :  PF_23
 * @Description : 有序数组的 Two Sum
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @date : 2020/01/03.
 */

public class Num01 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return null;
        }
        int lo = 0, hi = numbers.length - 1;
        int[] res = new int[2];
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                res[0] = lo;
                res[1] = hi;
                return res;
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return null;
    }
}

