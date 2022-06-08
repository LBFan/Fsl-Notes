package com.fan.focusoffer2;

import java.util.Random;

/**
 * @author : PF_23
 * @Description : 数组中第k大的数字
 * @date : 2022/5/3 10:37.
 */

public class Num76 {

    public int findKthLargest(int[] nums, int k) {
        // 利用快排思想
        // 第k大的数字在排序后肯定是数组中的nums[length - k],因为排序后是升序
        int target = nums.length - k;
        int end = nums.length - 1, start = 0;
        // 求partition，知道
        int index = partition(nums, start, end);
        while (index != target) {
            //说明还没找到第k大的数字下标
            if (index > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }

        return nums[index];


    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);

        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, small, i);
            }
        }

        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}

