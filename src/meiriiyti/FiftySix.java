package meiriiyti;

/**
 * @author : PF_23
 * @Description : 寻找数组中两个只出现一次的数
 * @date : 2020/04/28.
 */

public class FiftySix {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int diff = 0;
        // 求出两个只出现了一次的数字的异或值
        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;
        int[] res = new int[2];
        for (int num : nums) {
            if ((diff & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}

