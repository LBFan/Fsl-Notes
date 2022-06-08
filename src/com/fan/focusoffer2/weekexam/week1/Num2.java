package com.fan.focusoffer2.weekexam.week1;

/**
 * @author : PF_23
 * @Description : 二进制加法
 * @date : 2022/3/5 11:02.
 */

public class Num2 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        // 表示进位
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            // 从右到左计算，符合整数加减规律，和大于等于2时有进位
            int charA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int charB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = charA + charB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            // 计算出每一位的结果，存储在stringbuilder中
            stringBuilder.append(sum);
        }

        if (carry == 1) {
            stringBuilder.append(1);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010101010111100101010101011010100101101010";
        String b = "111100101010101011010100101101010";
        Num2 num2 = new Num2();
        String addBinary = num2.addBinary(a, b);
        System.out.println(addBinary);
    }
}

