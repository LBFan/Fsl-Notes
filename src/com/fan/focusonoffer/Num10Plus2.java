package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 矩形覆盖
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * 递归公式：
 *  f(n)=1,                     n = 1;
 *  f(n)=2,                     n = 2;
 *  f(n)=f(n - 1) + f(n - 2),   n > 2;
 * @date : 2019/12/17.
 */

public class Num10Plus2 {
    public static int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        int i = RectCover(n);
        System.out.println(i);
    }
}

