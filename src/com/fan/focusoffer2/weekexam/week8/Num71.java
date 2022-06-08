package com.fan.focusoffer2.weekexam.week8;

import java.util.Random;

/**
 * @author : PF_23
 * @Description : 按权重生成随机数
 * @date : 2022/5/14 10:38.
 */

public class Num71 {

    public int getRandomByWeight(int[] nums) {
        // 如[1,2,3,4] : 那么生成1 的权重是10%， 3的权重是30%
        // 思路一：直接将转换后的数组填充出来，然后随机取一个数
        // 思路二： 利用二分查找，先构造sum数组
        int[] sums = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            sums[i] = total;
        }

        // 现在随机取一个下标，求出随机值
        Random random = new Random();
        int p = random.nextInt(total);

        int left = 0, right = sums.length;
        while (left <= right) {
            int mid = left + (right  - left) / 2;
            if (sums[mid] > p) {
                //如果sums[mid]大于p并且： mid = 0 或者sums[mid - 1] 小于等于 p ,那么mid就是要找的随机值
                if (mid == 0 || sums[mid - 1] <= p) {
                    return mid;
                }

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

