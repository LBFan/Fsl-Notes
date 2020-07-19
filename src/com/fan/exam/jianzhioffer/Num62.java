package com.fan.exam.jianzhioffer;

/**
 * @Description : 圆圈中最后剩下的数字
 * 约瑟夫环
 * 两种方法： 模拟环形链表 、找规律
 * @Author : shulin.fan
 * @Date : 2020/7/19
 */
public class Num62 {

    public static int lastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        int solution = lastRemaining_Solution(n, m);
        System.out.println(solution);
    }

}
