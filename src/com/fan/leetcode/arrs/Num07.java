package com.fan.leetcode.arrs;

/**
 * @author :  PF_23
 * @Description : 找出数组中重复的数，数组值在 [1, n] 之间
 * 要求不能修改数组，也不能使用额外的空间。
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * @date : 2020/02/25.
 */

public class Num07 {
    /**
     * 二分查找解法
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int cnt = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int findDuplicateBy2Link(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        Num07 num07 = new Num07();
        int duplicate = num07.findDuplicate(nums);
        int duplicateBy2Link = num07.findDuplicateBy2Link(nums);
    }
}

