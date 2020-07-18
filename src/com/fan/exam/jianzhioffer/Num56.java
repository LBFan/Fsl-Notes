package com.fan.exam.jianzhioffer;

/**
 * @Description : 数组中数字出现的次数
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num56 {

    public static int[] findNumsAppearOnce(int[] nums) {
        int[] res = new int[2];
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        // 得到出 diff 最右侧不为 0 的位
        diff &= -diff;
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
