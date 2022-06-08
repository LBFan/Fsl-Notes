package com.fan.focusoffer2;

import java.util.Random;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/5/3 10:10.
 */

public class QuickSort {

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quicksort(nums, start, pivot - 1);
            quicksort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        // 将随机找到的数放在数组最后面
        swap(nums, random, end);

        int small = start - 1;
        // 将所有小于nums[end]小于的数放在左边
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, i, small);
            }
        }

        // 将nums[end]与nums[small]交换，也就是把选出来的数字放到正确的位置，
        // 使其左边的数字都小于自己，右边的数字都大于自己
        small++;
        swap(nums, small, end);

        //返回当前选出数字的下标
        return small;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {4, 1, 5, 6, 2, 7, 8, 3};
        QuickSort quickSort = new QuickSort();
        int[] ints = quickSort.sortArray(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}

