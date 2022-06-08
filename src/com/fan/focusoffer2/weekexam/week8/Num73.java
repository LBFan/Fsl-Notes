package com.fan.focusoffer2.weekexam.week8;

/**
 * @author : PF_23
 * @Description : 狒狒吃香蕉
 * @date : 2022/5/14 10:39.
 */

public class Num73 {

    public int getMinHours(int[] pipes, int h) {
        //每小时只能吃一堆，所以每小时最少吃1根，最多吃最大堆的香蕉数
        //使用二分法
        //先求出最大值
        int max = Integer.MIN_VALUE;
        for (int pipe : pipes) {
            max = Math.max(max, pipe);
        }

        int left = 1, right = max;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            // 根据每小时吃mid根香蕉计算是否满足h小时要求
            int hours = getHours(mid, pipes);
            if (hours <= h) {
                if (mid == 1 || getHours(mid - 1, pipes) > h) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int getHours(int mid, int[] pipes) {
        int hours = 0;
        for (int pipe : pipes) {
            hours += (pipe + mid - 1) / mid;
        }
        return hours;
    }
}

