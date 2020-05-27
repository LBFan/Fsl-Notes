package leetcode.dp.maxsublist;

/**
 * @author :  PF_23
 * @Description : 最长递增子序列
 * @date : 2020/01/07.
 */

public class Num01 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        // 使用 Stream 求最大值会导致运行时间过长
        // return Arrays.stream(dp).max().orElse(0);

        int ret = 1;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public int lengthOfLISByBinary(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tail, len, num);
            tail[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

