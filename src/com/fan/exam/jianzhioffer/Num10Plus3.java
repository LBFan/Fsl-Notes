package com.fan.exam.jianzhioffer;

/**
 * @Description : 跳台阶
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num10Plus3 {
    public int JumpFloor(int n) {
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
}
