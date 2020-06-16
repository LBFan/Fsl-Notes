package com.fan.huawei;

/**
 * @author :  PF_23
 * @Description : 1块钱可以买1瓶汽水，2个汽水瓶可以换一瓶汽水，4个瓶盖可以换一瓶汽水，请用编程实现有n块钱的时候，最多可以喝多少瓶汽水？
 * @date : 2020/04/15.
 */

public class MainPlus {

    public static void main(String[] args) {
        int n = (int) (Math.random() * (10 - 1) + 2);
        System.out.println(n);
        System.out.println(bottle(n));
    }

    private static int bottle(int n) {
        int count = n;
        // 喝完后全是空瓶和瓶盖
        int t = n;
        int g = n;
        if (n > 0) {
            while (t > 0 || g > 3) {
                count += t / 2;
                count += g / 4;
                t = t % 2 + t / 2 + g / 4;
                g = t + g % 4;
                if (t == 1) {
                    count++;
                    t = 0;
                }
                if (g == 4) {
                    count++;
                    g = 1;
                }
            }
        }

        return count;
    }
}

