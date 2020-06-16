package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 数字在排序数组中出现的次数
 * <p>
 * Input:
 * nums = 1, 2, 3, 3, 3, 3, 4, 6
 * K = 3
 * <p>
 * Output:
 * 4
 * <p>
 * 肯定要用到二分
 * 分别找出数字在数组中第一次出现的下标和第一个比该数字大的数字在数组中第一次出现的下标
 * @date : 2019/12/31.
 */

public class Num53 {

    public int GetNumberOfK(int[] nums, int K) {
        int firstFind = binarySearch(nums, K);
        int lastFind = binarySearch(nums, K + 1);
        return (firstFind == nums.length || nums[firstFind] != K) ? 0 : lastFind - firstFind;

    }

    private int binarySearch(int[] nums, int K) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= K) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3;
        int i = new Num53().GetNumberOfK(nums, k);
        System.out.println(i);
    }
}

