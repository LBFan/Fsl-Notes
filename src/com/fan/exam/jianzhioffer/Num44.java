package com.fan.exam.jianzhioffer;

/**
 * @Description : 数字序列中某一位的数字
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num44 {
    public static int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digit = 1;
        while (true) {
            int numbers = countOfIntegers(digit);
            if (index < numbers) {
                return digitAtIndex(index, digit);
            }
            index -= numbers;
            digit++;
        }
    }

    private static int digitAtIndex(int index, int digit) {
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
        int digitAtIndex = digitAtIndex(index);
        System.out.println(digitAtIndex);
    }
}
