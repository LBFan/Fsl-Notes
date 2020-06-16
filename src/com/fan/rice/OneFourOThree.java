package com.fan.rice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 非递增顺序的最小子序列
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,10,9,8]
 * 输出：[10,9]
 * 解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,7,6,7]
 * 输出：[7,7,6]
 * 解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。
 * 示例 3：
 * <p>
 * 输入：nums = [6]
 * 输出：[6]
 * @date : 2020/04/09.
 */

public class OneFourOThree {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        //降序排序
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = new Integer(nums[i]);
        }
        Arrays.sort(newNums, Collections.reverseOrder());
        int sum = 0;
        for (int num : newNums) {
            sum += num;
        }
        int halfSum = sum / 2;
        // 要求子序列和大于halfSum
        int subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            subSum += newNums[i];
            res.add(newNums[i]);
            if (subSum > halfSum) {
                break;
            }
        }
        return res;
    }
}

