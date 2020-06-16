package com.fan.leetcode.math;

/**
 * @author :  PF_23
 * @Description : 平方数
 * Input: 16
 * Returns: True
 * 平方序列：1,4,9,16,..
 * <p>
 * 间隔：3,5,7,...
 * <p>
 * 间隔为等差数列，使用这个特性可以得到从 1 开始的平方序列。
 * @date : 2020/02/25.
 */

public class Num10 {
    public boolean isPerfectSquare(int num) {
        int subNum = 1;
        while (num > 0) {
            num -= subNum;
            subNum += 2;
        }
        return num == 0;
//        return (int)Math.sqrt(num) * Math.sqrt(num) == num;
    }

    public static void main(String[] args) {
//        int n = 6;
        int n = 16;
        boolean perfectSquare = new Num10().isPerfectSquare(n);
        System.out.println(perfectSquare);
    }

}

