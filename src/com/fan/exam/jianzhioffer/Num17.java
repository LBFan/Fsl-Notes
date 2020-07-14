package com.fan.exam.jianzhioffer;

/**
 * @Description : 打印从1到最大的n位数 字符数组模拟数字加1 todo:超级重要。大数问题
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num17 {
    public static void printOneToMaxNDigit(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private static void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private static void printNumber(char[] number) {
        int index = 0;
        // '010' -> 10
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printOneToMaxNDigit(2);
    }
}
