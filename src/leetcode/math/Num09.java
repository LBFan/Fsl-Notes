package leetcode.math;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 数组中出现次数多于 n / 2 的元素
 * @date : 2020/02/25.
 */

public class Num09 {
    /**
     * 先对数组排序，最中间那个数出现次数一定多于 n / 2。
     *
     * @param nums
     * @return
     */
    private int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // method2 : 使用map统计每个数出现的次数，求出出现次数多余 n/ 2的元素

    private int majorityElementByBMMV(int[] nums) {
        int count = 0, majority = nums[0];
        for (int num : nums) {
            majority = (count == 0) ? num : majority;
            count = (majority == num) ? count + 1 : count - 1;
        }
        return count;
    }
}

