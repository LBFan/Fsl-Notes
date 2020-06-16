package com.fan.hanshunping.datastructrue.sort;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/17.
 */

public class SwapUtil {
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

