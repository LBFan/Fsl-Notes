package com.fan.focusoffer2.weekexam.week8;

import com.fan.hanshunping.datastructrue.sort.SwapUtil;

import java.util.Random;

/**
 * @author : PF_23
 * @Description : 数组中第k大的数字，快速排序法
 * @date : 2022/5/14 10:47.
 */

public class Num76 {

    //本题利用快排的思想

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        // 这里的target就是下标,排序后应该存在的下标（第k大的数字）
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != target) {
            if (index > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }

            index = partition(nums, start, end);
        }

        return index;

    }

    /**
     * 快排
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if (end > start) {
            int pivot = partition(nums, start, end);
            quicksort(nums, start, pivot - 1);
            quicksort(nums, pivot + 1, end);
        }

    }

    private int partition(int[] nums, int start, int end) {
        // 求随机中间值下标
        int random = new Random().nextInt(end - start + 1) + start;
        // 先将random值交换到end位置
        SwapUtil.swap(nums, random, end);

        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                SwapUtil.swap(nums, small, i);
            }
        }

        small++;
        SwapUtil.swap(nums, small, end);

        return small;

    }

}

