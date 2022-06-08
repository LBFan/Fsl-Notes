package com.fan.focusoffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 0和1个数相同的最长子数组
 * 可以把0当做-1，这样就是求和为0的最长子数组的长度了
 * @date : 2022/3/9 22:03.
 */

public class Num11 {


    /**
     * 11题 * 思路：1.暴力解，这肯定不是想要的结果 *
     * 2. 相同个数的0和1，如果把0换成-1，就是连续子数组和为0，转换为上一题的思路了
     * * 不过这个题是求连续子数组的最大长度，所以需要改变一点map的定义：key为从第0个下标开始，到当前下标的连续数组的和，value为当前下标
     * * 首先需要定义一个map.put(0, -1): 表示在遍历之前，和为0的连续子数组还没出现，下标用-1标识
     * * 然后从第一个树开始遍历，并且记录下遍历到当前下标时的连续子数组的和，将0换为-1计算，这样就是求和为0的连续子数组了
     * * 定义一个变量，作为最终的返回结果： maxLen = 0;
     * * 每次将当前值加上之后，如果map中已经存在和为sum的key，说明中间一段的连续子数组和为0，即为出现相同个数的0和1，记录下来，
     * 遍历完一遍数组后，取最大长度返回
     *
     * @param nums
     * @return
     */
    public int maxLen(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 将0当做-1看
            sum += nums[i] == 0 ? -1 : 1;
            if (sumCount.containsKey(sum)) {
                maxLen = Math.max(i - sumCount.get(sum), maxLen);
            } else {
                sumCount.put(sum, i);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        Num11 num11 = new Num11();
        int[] nums = {0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0};
        int i = num11.maxLen(nums);
        System.out.println(i);
    }

}



