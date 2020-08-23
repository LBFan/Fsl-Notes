package com.fan.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description : 熟悉的A+B
 * A+B问题又来了。
 *
 * 设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数，现给定一正整数n，问有多少对abc和acc能满足abc+acc=n（a≠0）
 * @Author : shulin.fan
 * @Date : 2020/8/21
 */
public class Main2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    List<Integer> tmp = new ArrayList<>();
                    if ((i != j && i != k && j != k) && (200 * i + 10 * j + 12 * k == num)) {
                        count++;
                        tmp.add(i);
                        tmp.add(j);
                        tmp.add(k);
                        list.add(tmp);
                    }
                }
            }
        }
        if (count <= 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < count; ++i) {
                List<Integer> res = list.get(i);
                System.out.println(count);
                for (int j = 0; j < count; j++) {
                    int first = res.get(0) * 100 + res.get(1) * 10 + res.get(2);
                    int second = res.get(0) * 100 + res.get(2) * 10 + res.get(2);
                    System.out.print(first + " " + second);
                }
            }
        }

    }
}
