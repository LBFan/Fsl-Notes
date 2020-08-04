package com.fan.leetcode.interview200;

/**
 * @Description : 整数反转
 * 要考虑数据溢出的问题
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0
 * @Author : shulin.fan
 * @Date : 2020/8/3
 */
public class Num05 {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    // 方法2 ： 尝试使用字符串反转 超时

    public static int reverse2(int x) {
        int num = x < 0 ? -x : x;
        String s = String.valueOf(num);
        String res = swap(s, 0, s.length());
        int rev = Integer.parseInt(res);
        return x < 0 ? -rev : rev;
    }

    private static String swap(String s, int left, int right) {
        char[] chars = s.toCharArray();
        int l = left, r = right;
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
        }
        return new String(chars);
    }
}
