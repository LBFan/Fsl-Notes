package com.fan.bit;

import java.math.BigInteger;
import java.util.Stack;


/**
 * @Description : 任意大数进制转换
 * @Author : shulin.fan
 * @Date : 2020/8/8
 */
public class MathUtil {

    /**
     * 理论上支持62进制的转换, 当然可以自己添加一些其他符号来增加进制数
     */
    private static final String STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char[] chars = STRING.toCharArray();
    private static final BigInteger Zero = new BigInteger("0");


    /**
     * 10进制转任意进制
     */
    public static String numToRadix(String number, int radix) {
        if (radix < 0 || radix > STRING.length()) {
            radix = STRING.length();
        }

        BigInteger bigNumber = new BigInteger(number);
        BigInteger bigRadix = new BigInteger(radix + "");

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(0);
        while (!bigNumber.equals(Zero)) {
            stack.add(chars[bigNumber.remainder(bigRadix).intValue()]);
            bigNumber = bigNumber.divide(bigRadix);
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    /**
     * 任意进制转10进制
     */
    public static String radixToNum(String number, int radix) {
        if (radix < 0 || radix > STRING.length()) {
            radix = STRING.length();
        }
        if (radix == 10) {
            return number;
        }

        char ch[] = number.toCharArray();
        int len = ch.length;

        BigInteger bigRadix = new BigInteger(radix + "");
        BigInteger result = new BigInteger("0");
        BigInteger base = new BigInteger("1");


        for (int i = len - 1; i >= 0; i--) {
            BigInteger index = new BigInteger(STRING.indexOf(ch[i]) + "");
            result = result.add(index.multiply(base));
            base = base.multiply(bigRadix);
        }

        return result.toString();
    }


    /**
     * 任意进制之间的互相转换, 先将任意进制转为10进制, 然后在转换为任意进制
     */
    public static String transRadix(String num, int fromRadix, int toRadix) {
        return numToRadix(radixToNum(num, fromRadix), toRadix);
    }

    public static void main(String[] args) {

        // out : 50664
        System.out.println(numToRadix("12345", 7));

        //将一个大到随意的数字转换为尽可能的短
        //res: 3laVtRb0zg2IOs3nqp
        //System.out.println(numToRadix("9876589123612391237018273912873", 62));

        //将 1010 从 2进制 转换为 10进制
        //res: 10
        //System.out.println(radixToNum("1010", 2));

        //将 1010 从 2进制 转换为 16进制
        //res: a
        //System.out.println(transRadix("1010", 2, 16));
    }

}

