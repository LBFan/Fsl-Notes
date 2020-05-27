package leetcode.bitcompute;

/**
 * @author :  PF_23
 * @Description : 找出数组中缺失的那个数
 * @date : 2020/02/13.
 */

public class Num03 {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i ^ nums[i]);
        }
        return res ^ nums.length;
    }
}

