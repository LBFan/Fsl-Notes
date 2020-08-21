package com.fan.leetcode.favorate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description : 三数之和
 * @Author : shulin.fan
 * @Date : 2020/8/17
 */
public class Num09 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序 + 双指针
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = n - 1;
            List<Integer> tmp;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l++]);
                    tmp.add(nums[r--]);
                    res.add(tmp);
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }

            }
        }
        return res;
    }
}
