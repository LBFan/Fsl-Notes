package com.fan.dianxin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description : 删除字符串中出现次数最少的字符
 * @Author : shulin.fan
 * @Date : 2020/9/16
 */
public class Main02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String res = delete(s);
        System.out.println(res.toString());
    }

    public static String delete(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (int times : map.values()) {
            min = Math.min(min, times);
        }
        StringBuilder res = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (map.get(ch) != min) {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
