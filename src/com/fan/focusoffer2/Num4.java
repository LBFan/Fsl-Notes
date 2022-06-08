package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : 数组中只出现一次的数字
 * @date : 2022/3/3 22:05.
 */

public class Num4 {

    public int oneNumber(int[] nums) {
        //  位运算，出现3次的数字当前为必然为3，出现一次的 % 3不为0
        int[] bitSum = new int[32];
        // 求出每一位二进制位出现的次数和
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                bitSum[i] += (num >> (31 - i)) & 1;
            }
        }

        // 求出每一位是否为3的整数倍，是则当前为为0，否则为1
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSum[i] % 3;
        }

        return result;
    }

    public static void main(String[] args) {
        Num4 num4 = new Num4();
        int[] nums = {1, 2, 1, 2, 1, 2, 3, 5, 3, 3};
        int oneNumber = num4.oneNumber(nums);
        System.out.println(oneNumber);
    }
}

