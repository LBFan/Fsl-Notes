package leetcode.dp.fibo;

/**
 * @author :  PF_23
 * @Description : 强盗在环形街区抢劫
 * 相比上一题，主要多了首尾相连，所以 max = Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
 * @date : 2020/01/06.
 */

public class Num03 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int first, int last) {
        int pre2 = 0, pre1 = 0;
        for (int i = first; i <= last; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}

