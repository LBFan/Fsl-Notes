package com.fan.leetcode.binarysearch;

/**
 * @author :  PF_23
 * @Description : 有序数组的 Single Element
 * 一个有序数组只有一个数不出现两次，找出这个数。
 * 要求以 O(logN) 时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。
 * <p>
 * 令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。
 * 如果 mid 为偶数，并且 mid + 1 < index，那么 nums[mid] == nums[mid + 1]；
 * mid + 1 >= index，那么 nums[mid] != nums[mid + 1]。
 * 从上面的规律可以知道，
 * 如果 nums[mid] == nums[mid + 1]，那么 index 所在的数组位置为 [mid + 2, h]，此时令 l = mid + 2；
 * 如果 nums[mid] != nums[mid + 1]，那么 index 所在的数组位置为 [l, mid]，此时令 h = mid。
 * 因为 h 的赋值表达式为 h = mid，那么循环条件也就只能使用 l < h 这种形式。
 * @date : 2020/02/09.
 */

public class Num03 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = (l + h) >>> 1;
            if (mid % 2 == 1) {
                // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }

    /**
     * 位运算，异或法O(n)
     *
     * @param nums 数组
     * @return 只出现一次的数字
     */
    public int singleNonDuplicateByte(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}

