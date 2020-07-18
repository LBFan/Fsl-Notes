package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 * <p>
 * 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
 * <p>
 * diff &= -diff 得到出 diff 最右侧不为 0 的位，
 * 也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
 * @date : 2019/12/31.
 */

public class Num56 {

    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        // diff为两个不同数字的异或值
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // 得到出 diff 最右侧不为 0 的位
        diff &= -diff;
        for (int num : nums) {
            if ((diff & num) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Num56().FindNumsAppearOnce(nums, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}

