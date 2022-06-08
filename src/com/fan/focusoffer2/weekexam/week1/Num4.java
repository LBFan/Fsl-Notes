package com.fan.focusoffer2.weekexam.week1;

/**
 * @author : PF_23
 * @Description : 只出现一次的数字
 * @date : 2022/3/5 11:43.
 */

public class Num4 {

    public int oneTime(int[] nums) {
        int[] bitSum = new int[32];
        // 将所有数字的二进制位分别加上，每一位的和放在bitSum的对应下标值里
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                bitSum[i] |= (num >> (31 - i) & 1);
            }
        }

        // 拆分，求出每一位中出现一次的数字是0还是1
        // 如果bitSum[i] 是三的整数倍，则必然出现一次的数字在这位二进制位为0；反之为1
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (bitSum[i] % 3 == 0 ? 0 : 1);
        }

        return result;

    }

    public int oneTime2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num & (1 << i));
            }
            if (cnt % 3 != 0) {
                res += (1 << i);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 1, 1, 1, 1, 3, 2, 2,5,5,5};
        Num4 num4 = new Num4();
        int oneTime = num4.oneTime2(nums);

        System.out.println(oneTime);
    }
}

