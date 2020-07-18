package com.fan.exam.jianzhioffer;

/**
 * @Description : 数组中的逆序对
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num51 {
    private static long cnt = 0;
    /**
     * 在这里声明辅助数组，而不是在 merge() 递归函数中声明
     */
    private static int[] tmp;

    public static int inversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private static void mergeSort(int[] nums, int l, int h) {
        if (l >= h) {
            return;
        }
        int mid = l + (h - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }

    private static void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                tmp[k++] = nums[j++];
            } else if (j > h) {
                tmp[k++] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                cnt += m - i + 1;
            }
        }
        for (k = l; k <= h; k++) {
            tmp[k] = nums[k];
        }
    }

}
