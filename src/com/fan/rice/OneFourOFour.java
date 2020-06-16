package com.fan.rice;

/**
 * @author :  PF_23
 * @Description : 将二进制表示减到 1 的步骤数
 * @date : 2020/04/09.
 */

public class OneFourOFour {
    //
    public int numSteps(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int carry = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if(i == 0 && carry == 0) {
                break;
            }
            if(s.charAt(i) - '0' != carry){
                carry = 1;
                ans += 1;
            }
            ans += 1;
        }
        return ans;
    }

    private int steps(int num) {
        if (num == 1) {
            return 0;
        }
        return num % 2 == 1 ? 1 + steps(num + 1) : 1 + steps(num / 2);
    }

    public static void main(String[] args) {
        String s = "11000";
        int numSteps = new OneFourOFour().numSteps(s);
        System.out.println(numSteps);
    }
}

