package com.fan.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/8/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            //int bottle = bottle(n);
            //System.out.println(bottle);
            list.add(n);
            n = in.nextInt();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) / 2);
        }

    }
    //public static void main(String[] args) {
    //    Scanner in = new Scanner(System.in);
    //    String str = in.nextLine();
    //    String[] strArr = str.trim().split(" ");
    //    int len = strArr[strArr.length - 1].length();
    //    System.out.println(len);
    //}

    private static int bottle(int n) {
        // 迭代
        int num = n;
        int res = 0;
        while (num > 0) {
            res += (num / 3);
            if (num / 3 == 1 && num % 3 == 1) {
                res += 1;
                break;
            }
            if (num / 3 == 1 && num % 3 == 2) {
                res += 2;
                break;
            }
            if (num / 3 == 1) {
                break;
            }
            num = (num / 3 + num % 3);

        }
        return res;
    }
}
