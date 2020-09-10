package com.fan.exam.jianzhioffer;

/**
 * @Description : 数组中数字出现的次数
 * 一个整型数组里除了一个数字之外，其他的数字都出现了三次，找出这个数。
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num56PlusOne {

    public static int findNumsAppearOnce(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 4, 4};
        //int numsAppearOnce = findNumsAppearOnce(nums);
        //System.out.println(numsAppearOnce);
        int one = 4;
        // -5
        System.out.println(~one);
    }
}
