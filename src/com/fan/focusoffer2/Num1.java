package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/3 22:04.
 */

public class Num1 {


    public int divide(int dividend, int divisor) {
        // 利用负数，因为正数转换为负数不会溢出
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negative = 2;
        if (dividend >= 0) {
            negative--;
            dividend = -dividend;
        }

        if (divisor >= 0) {
            negative--;
            divisor = -divisor;
        }

        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    private int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int quotient = 1;
            int value = divisor;
            while (value >= 0xc0000000 && dividend <= value + value) {
                value += value;
                quotient += quotient;
            }

            result += quotient;
            dividend -= value;
        }

        return result;
    }

    public static void main(String[] args) {
        Num1 num1 = new Num1();
        int dividend = 13, divisor = 4;
        int divide = num1.divide(13, 4);
        System.out.println(divide);
    }
}

