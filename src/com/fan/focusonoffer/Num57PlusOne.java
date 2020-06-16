package com.fan.focusonoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 和为 S 的两个数字
 * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 * 其实就是最小和最大的两个数字和为S时，输出这两个数
 * <p>
 * 双指针法
 * @date : 2019/12/31.
 */

public class Num57PlusOne {
    public List<Integer> FindNumbersWithSum(int[] nums, int sum) {
        // 双指针
        List<Integer> list = new ArrayList<>();
        int lo = 0, hi = nums.length - 1;
        while (true) {
            int t = nums[lo] + nums[hi];
            if (t == sum) {
                list.add(nums[lo]);
                list.add(nums[hi]);
                break;
            } else if (t < sum) {
                lo++;
            } else {
                hi--;
            }
        }
        return list;
    }
}

