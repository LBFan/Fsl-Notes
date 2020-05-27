package leetcode.arrs;

/**
 * @author :  PF_23
 * @Description :  把数组中的 0 移到末尾
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 要求不改变数组的原来顺序
 * @date : 2020/02/25.
 */

public class Num01 {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}

