package com.fan.exam.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 打印从1到最大的n位数 字符数组模拟数字加1 todo:超级重要。大数问题
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num17 {
    static int[] res;
    static List<Integer> list;

    public static int[] printOneToMaxNDigit(int n) {
        if (n <= 0) {
            return new int[0];
        }
        list = new ArrayList<>();
        res = new int[(int) (Math.pow(10, n ) - 1)];
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
        list = list.subList(1, list.size());
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void print1ToMaxOfNDigits(char[] number, int digit) {
        // 递归终止条件！！！
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            // 递归，直到digit == number.length
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private static void printNumber(char[] number) {
        int index = 0;
        // '010' -> 10 去掉前面的0
        //while (index < number.length && number[index] == '0') {
        //    index++;
        //}
        int num = 0;
        while (index < number.length) {
            num = 10 * num + (number[index++] - '0');
            //System.out.print(number[index++]);
        }
        list.add(num);
        //System.out.println();
    }

    public static void main(String[] args) {
        printOneToMaxNDigit(2);
        //System.out.println("===========================");
        for (int r : res) {
            System.out.print(r + "  ");
        }
    }
}
