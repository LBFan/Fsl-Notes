package com.fan.exam.jianzhioffer;

/**
 * @Description : 不修改数组找出其中一个重复的数字.范围在1~n的 n + 1个数字中 说明：此方法适用于时间换空间；若要空间换时间，使用hash作答
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num03Plus {
    public static int getDuplication(int[] nums, int length) {
        if (nums == null || length <= 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int mid = ((end - start) >>> 1) + start;
            int count = countRange(nums, length, start, mid);
            if (end == start) {
                if (count > 1) {
                    // 说明值为start的数字有多个，直接返回
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                // start ~ mid 的值得个数大于长度，此区间有重复值
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] nums, int length, int start, int end) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                ++count;
            }
        }
        return count;
    }
}
