package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : 整数除法
 * @date : 2022/3/3 22:04.
 */

public class Num2 {

    public String addBinary (String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        int la = a.length() - 1, lb = b.length() - 1;
        while (la >= 0 || lb >= 0) {
            int charA = la >= 0 ? a.charAt(la--) - '0' : 0;
            int charB = lb >= 0 ? b.charAt(lb--) - '0' : 0;
            int sum = charA + charB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            stringBuilder.append(sum);
        }

        if (carry == 1) {
            stringBuilder.append(1);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1011";
        String b = "10111";
        Num2 num2 = new Num2();
        String s = num2.addBinary(a, b);
        System.out.println(s);

    }
}

