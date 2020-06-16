package com.fan.leetcode.strings;

/**
 * @author :  PF_23
 * @Description : 判断一个整数是否是回文数
 * 要求不能使用额外空间，也就不能将整数转换为字符串进行判断。
 * <p>
 * 将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
 * @date : 2020/02/19.
 */

public class Num08 {
    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }

    public static void main(String[] args) {
        int n = 123321;
        boolean palindrome = isPalindrome(n);
        System.out.println(palindrome);
    }
}

