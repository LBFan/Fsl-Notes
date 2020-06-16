package com.fan.meituan;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/26.
 * 有这么一个奇怪的符号：在一张正方形的纸上，有许多不同半径的圆。他们的圆心都在正方形的重心上（正方形的重心位于正方形两条对角线的交叉点上）。
 * <p>
 * 最大的圆的外面部分是白色的。最外层的圆环被涂成了黑色，接下来第二大的圆环被涂层白色，接下来第三大的圆环被涂层黑色。以此类推，例如下图。
 * <p>
 * 现在，给你这些圆的半径，请问黑色部分的面积是多少？精确到小数点后5位输出（四舍五入）。
 * <p>
 * <p>
 * 输入
 * 输入包含两行。第一行一个整数n，表示圆的个数。
 * <p>
 * 接下来n个整数，描述每个圆的半径ri。数据保证没有两个圆的半径是一样的。(1<=n<=100 , ri<=1000)
 * <p>
 * 输出
 * 输出包含一个数，代表黑色部分的面积。
 * <p>
 * n为偶数时，面积为大面积 - 小面积，最后求总和
 * n为奇数时，面积为大面积 - 小面积，再加上最后一个小圆形面积，最后求总和
 * <p>
 * π * r * r
 */

public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rArr = new int[n];
        for (int i = 0; i < n; i++) {
            rArr[i] = sc.nextInt();
        }

        double res = 0;
        // n为偶数
        if (isEven(n)) {
            for (int i = n - 1; i >= 1; i -= 2) {
                double areaBig = Math.PI * rArr[i] * rArr[i];
                double areaSmall = Math.PI * rArr[i - 1] * rArr[i - 1];
                res += (areaBig - areaSmall);
            }
        } else {
            for (int i = n - 1; i >= 1; i -= 2) {
                double areaBig = Math.PI * rArr[i] * rArr[i];
                double areaSmall = Math.PI * rArr[i - 1] * rArr[i - 1];
                res += (areaBig - areaSmall);
            }
            res += (Math.PI * rArr[0] * rArr[0]);
        }
        System.out.printf(String.format("%.5f", res));
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}

