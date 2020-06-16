package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 * <p>
 * 思路:
 * 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
 * 使用回溯法得到所有的数。
 * 发现数的每一位都是0到9，所以可以利用全排列的思想，凭借递归的优雅实现达到目的。比如输入3，我们数的打印顺序为
 * 001
 * 002
 * …
 * 010
 * 011
 * 012
 * …
 * 100
 * 101
 * …
 * 999
 * 我们从高位开始，对于每一位都递归的用0-9填充，最后递归结束条件为已考察到所有的位，打印并且回溯到最后一位，重新对该位赋予下一个值。
 * TODO:
 * @date : 2019/12/18.
 */

public class Num17 {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 2;
        new Num17().print1ToMaxOfNDigits(n);
    }
}

