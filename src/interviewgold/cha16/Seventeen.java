package interviewgold.cha16;

/**
 * @author :  PF_23
 * @Description : 连续数列
 * 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 * <p>
 * 示例：
 * <p>
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @date : 2020/04/07.
 */

public class Seventeen {

    /**
     * 方法一
     *
     * @param nums
     * @return
     */
    public static int maxSubArray01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    /**
     * 方法二:动态规划思想，便利到第i个元素时，当前位置的最大连续子序列和，然后比较max和nums[i]的值即可
     *
     * @param nums
     * @return
     */
    public static int maxSubArray02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int subArray02 = maxSubArray02(new int[]{2, 3, -8, -1, 2, 4, -2, 3});
        System.out.println(subArray02);

    }
}

