package com.fan.focusoffer2;

import java.util.*;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/4/7 22:16.
 */

public class Num60 {
    public static int[] getCountK(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        // 计数
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // 将出现的次数排序，取前k个
        int[] countsNum = new int[counts.size()];
        int i = 0;
        for (Integer value : counts.values()) {
            countsNum[i++] = value;
        }

        Arrays.sort(countsNum);
        int[] result = new int[k];
        i = 0;
        for (int j = countsNum.length - 1; j >= 0; j--) {
            for (Map.Entry<Integer, Integer> integerIntegerEntry : counts.entrySet()) {
                if (i < k && integerIntegerEntry.getValue() == countsNum[j]) {
                    result[i] = integerIntegerEntry.getKey();
                    i++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,
                1, 1, 2, 2, 3, 3, 4, 3, 3, 3, 5, 4, 3, 4, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 21, 22, 10, 8, 7, 9, 10};
        //int[] nums = {2};
        int[] countK = getCountK(nums, 10);
        for (int i : countK) {
            System.out.println(i);
        }
    }
}

