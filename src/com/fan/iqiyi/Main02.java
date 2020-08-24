package com.fan.iqiyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description : 判断路径是否相交
 * 题目描述：
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * <p>
 * 输出描述
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * <p>
 * 样例输入
 * ESSWNEE
 * 样例输出
 * True
 * @Author : shulin.fan
 * @Date : 2020/8/23
 */
public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        boolean pathCrossing = isPathCrossing(path);
        String res = pathCrossing ? "True" : "False";
        System.out.println(res);
    }

    private static boolean isPathCrossing(String path) {
        Set<Integer> visit = new HashSet<>();

        int x = 0, y = 0;
        visit.add(getHash(x, y));
        int len = path.length();
        for (int i = 0; i < len; i++) {
            char ch = path.charAt(i);
            switch (ch) {
                case 'N':
                    --x;
                    break;
                case 'S':
                    ++x;
                    break;
                case 'W':
                    --y;
                    break;
                case 'E':
                    ++y;
                    break;
            }
            int hash = getHash(x, y);
            if (!visit.add(hash)) {
                return false;
            }
        }
        return false;
    }

    private static int getHash(int x, int y) {
        return x * 10001 + y;
    }
}




























