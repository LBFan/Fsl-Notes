package com.fan.focusoffer2.weekexam.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 三数之和为0 的集合
 * @date : 2022/3/5 13:18.
 */

public class Num7 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length > 3) {
            // 先排序
            Arrays.sort(nums);

            int i = 0;
            while (i < nums.length - 2) {
                twoSum(nums, i, res);
                int tmp = nums[i];
                while (i < nums.length && tmp == nums[i]) {
                    i++;
                }
            }

        }
        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int j = i + 1, k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                int tmp = nums[j];
                while (j < k && tmp == nums[j]) {
                    j++;
                }
            }

            if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Num7 num7 = new Num7();
        List<List<Integer>> lists = num7.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}

