package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/3 22:05.
 */

public class Num9 {
    public int subArrayProductLen(int[] nums, int k) {
        // 双指针，连续子数组
        int result = 0;
        int n = nums.length, i = 0;
        int product = 1;
        for (int j = 0; j < n; j++) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i++];
            }
            result += (j >= i ? j - i + 1 : 0);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,2,3};
        int k = 7;
        Num9 num9 = new Num9();
        int count = num9.subArrayProductLen(nums, k);
        System.out.println(count);
    }
}

