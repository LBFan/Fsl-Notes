package com.fan.exam.jianzhioffer;

/**
 * @Description : 数字序列中某一位的数字
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num44 {

    public static int digitAtIndex01(int n) {
        // 解题思路：
        //将 101112⋯ 中的每一位称为 数位 ，记为 n；
        //将 10, 11, 12,... 称为 数字 ，记为 num ；
        //数字 1010 是一个两位数，称此数字的 位数 为 22 ，记为 digit；
        //每 digit位数的起始数字（即：1, 10, 100, ⋯），记为 start。
        //链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/


        //可将求解分为三步：
        //
        //确定 nn 所在 数字 的 位数 ，记为 digitdigit ；
        //确定 nn 所在的 数字 ，记为 numnum ；
        //确定 nn 是 numnum 中的哪一数位，并返回结果

        int digit = 1;
        long start = 1;
        long count = 9;
        // 1.
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * digit * start;
        }

        // 2.
        long num = start + (n - 1) / digit;
        // 3.
        return Long.toString(num).charAt((n - 1) % digit - '0');
    }

    public static int digitAtIndex02(int index) {
        if (index < 0) {
            return -1;
        }
        int digit = 1;
        while (true) {
            int numbers = countOfIntegers(digit);
            if (index < numbers) {
                return digitAtIndex02(index, digit);
            }
            index -= numbers;
            digit++;
        }
    }

    private static int digitAtIndex02(int index, int digit) {
        int number = beginNumber(digit) + index / digit;
        int indexFromRight = digit - index % digit;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private static int beginNumber(int digit) {
        if (digit == 1) {
            return 0;
        }
        return (int) Math.pow(10, digit - 1);
    }

    private static int countOfIntegers(int digit) {
        if (digit == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digit - 1) * 9;
        return digit * count;
    }

    public static void main(String[] args) {
        int index = 1001;
        int digitAtIndex = digitAtIndex02(index);
        System.out.println(digitAtIndex);
    }
}
