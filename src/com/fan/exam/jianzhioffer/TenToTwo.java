package com.fan.exam.jianzhioffer;

/**
 * @Description : 10进制转2进制
 * @Author : shulin.fan
 * @Date : 2020/9/11
 */
public class TenToTwo {
    public static void main(String[] args) {
        int n = 10;
        String tenToTwo = tenToTwo(n);
        System.out.println(tenToTwo);
    }

    private static String tenToTwo(int num) {
        if (num <= 0) {
            return "0";
        }
        int n = num;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int tmp = (n & 1);
            sb.append(tmp);
            n >>= 1;
        }
        return sb.reverse().toString();
    }

}
