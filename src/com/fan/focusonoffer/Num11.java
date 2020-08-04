package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * @date : 2019/12/17.
 */

public class Num11 {

    /**
     * 没有重复数字的情况
     *
     * @param nums 旋转数组
     * @return 最小值
     */
    public int minNumberInRotateArray(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];

    }

    /**
     * 有重复数字的情况
     * 如果数组元素允许重复，会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，此时无法确定解在哪个区间，
     * 需要切换到顺序查找。
     * 例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。
     *
     * @param nums 旋转数组
     * @return 最小值
     */
    public static int minNumberInRotateArrayWithRepeat(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                return minNumber(nums, lo, hi);
            } else if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];

    }

    private static int minNumber(int[] nums, int low, int hi) {
        for (int i = low; i < hi; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[low];
    }

    /**
     * 暴力法求解在有重复数字的情况下的最小数字
     *
     * @param nums
     * @return
     */
    private int minNumberInRotateArrayMethod3(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    /**
     * 适用于两种情况 （有无重复数字）
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

}

