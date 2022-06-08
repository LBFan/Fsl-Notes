package com.fan.focusoffer2.weekexam.week8;

/**
 * @author : PF_23
 * @Description : 求平方根
 * @date : 2022/5/14 10:38.
 */

public class Num72 {

    public int getNum(int num) {
        //思路 ： 二分法
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid <= num / mid) {
                // 当前值的平方小于num,同时当值加一的平方大于num，说明当前值就是该数的平方根
                if ((mid + 1) > (num / (mid + 1))) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}

