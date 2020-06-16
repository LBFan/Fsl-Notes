package com.fan.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :汽水瓶
 * @date : 2020/04/15.
 */

public class Main10 {
//    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int m;
        for (int i = 0; i < 11; i++) {
            m = sc.nextInt();
            list.add(m);
            if (m == 0) {
                break;
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
//            cnt = 0;
            int count = count(list.get(i));
            System.out.println(count);

        }
    }

    private static int count(int n) {
//        if (n < 3) {
//            return n == 2 ? cnt + 1 : cnt;
//        }
//        cnt++;
//        return count(n - 2);

        int count = 0;
        if (n > 0) {
            while (n > 1) {
                count += n / 3;
                n = n % 3 + n / 3;
                if (n == 2) {
                    count++;
                    n = 0;
                }
            }
        }
        return count;
    }
}

