package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : 求平方根
 * @date : 2022/4/18 21:43.
 */

public class Num72 {

    public int getNum(int x) {
        int left = 1;
        int right = (x >> 1);
        while (left <= right) {
            int mid = (right - left) >> 1 + left;
            if (mid <= (x / mid)) {
                if ((mid + 1) > (x / (mid + 1))) {
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

