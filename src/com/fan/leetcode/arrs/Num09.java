package com.fan.leetcode.arrs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 数组的度
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * 题目描述：数组的度定义为元素出现的最高频率，例如上面的数组度为 3。要求找到一个最小的子数组，这个子数组的度和原数组一样。
 * 思路很简单：
 * 三个map分别存贮每个数字的度和每个数字在数组中出现的最早、最晚位置
 * @date : 2020/02/26.
 */

public class Num09 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numsCnt = new HashMap<>();
        Map<Integer, Integer> numsLastIndex = new HashMap<>();
        Map<Integer, Integer> numsFirstIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            numsLastIndex.put(num, i);
            if (!numsFirstIndex.containsKey(num)) {
                numsFirstIndex.put(num, i);
            }
        }
        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numsCnt.get(num));
        }
        int res = nums.length;
        for (int i = 0; i < res; i++) {
            int num = nums[i];
            int cnt = numsCnt.get(num);
            if (cnt != maxCnt) {
                continue;
            }
            res = Math.min(res, numsLastIndex.get(num) - numsFirstIndex.get(num) + 1);
        }
        return res;
    }

}

