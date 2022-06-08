package com.fan.focusoffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 和为0的三元组
 * @date : 2022/3/3 22:05.
 */

public class Num7 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length >= 3) {
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                twoSum(nums, i, res);
                ;
                int tmp = nums[i];
                while (i < nums.length && tmp == nums[i]) {
                    i++;
                }
            }
        }
        return res;
    }

    private static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int tmp = nums[j];
                while (j < k && nums[j] == tmp) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {};
    }
}

