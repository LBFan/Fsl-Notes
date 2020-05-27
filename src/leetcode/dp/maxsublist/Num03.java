package leetcode.dp.maxsublist;

/**
 * @author :  PF_23
 * @Description : 最长摆动子序列
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * <p>
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * <p>
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * 要求：使用 O(N) 时间复杂度求解
 * @date : 2020/01/07.
 */

public class Num03 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}

