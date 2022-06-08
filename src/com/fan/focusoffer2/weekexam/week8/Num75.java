package com.fan.focusoffer2.weekexam.week8;

/**
 * @author : PF_23
 * @Description : 数组相对排序
 * @date : 2022/5/14 10:47.
 */

public class Num75 {

    public int[] sortByNext(int[] nums1, int[] nums2) {
        // 将nums1先按照nums2的顺序排序，剩余的按照出现的顺序排列， 使用计数排序
        //核心是统计每个数字出现的饿次数，使用一个桶记录
        int[] counts = new int[1001];
        for (int num : nums1) {
            counts[num]++;
        }

        int i = 0;
        for (int num : nums2) {
            while (counts[num] > 0) {
                nums1[i++] = num;
                counts[num]--;
            }
        }

        // 将剩余数字填充到num1中
        for (int i1 = 0; i1 < counts.length; i1++) {
            while (counts[i1] > 0) {
                nums1[i++] = i1;
                counts[i1]--;
            }
        }

        return nums1;
    }
}

