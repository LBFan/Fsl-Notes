package com.fan.focusoffer2;

import com.sun.corba.se.impl.oa.toa.TOA;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/9 22:26.
 */

public class Num12 {
    /**
     * 左右两边子数组的和相等：求出这个数的下标 1,2,3,4,6：结果为3.
     * 这个题比较简单： total - sum = sum - nums[i] : 返回i
     * <p>
     * 方法2：双指针 左右向中间靠
     */

    public int pivotIndex(int[] nums) {
        int total = 0;
        // 整个数组的和
        for (int num : nums) {
            total += num;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // ！！！注意：求的是当前数字的左右两边的子数组的和相等，
            // 所以左边的和应该为 sum - nums[i],右边的和为 total - sum
            if (sum - nums[i] == total - sum) {
                return i;
            }
        }
        // 如果不存在，则返回-1
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        // 使用双指针
        int i = 0;
        int j = nums.length - 1;
        int leftSum = 0, rightSum = 0;
        while (i < j) {
            leftSum += nums[i];
            rightSum += nums[j];
            //
            if (leftSum == rightSum && j - i == 2) {
                return i + 1;
            } else if (leftSum == rightSum && j - i > 2) {
                j--;
                i++;
            } else if (leftSum < rightSum && j - i > 2) {
                i++;
            } else if (leftSum > rightSum && j - i > 2){
                j--;
            }
        }

        return -1;
    }

}

