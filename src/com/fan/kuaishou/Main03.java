package com.fan.kuaishou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 排队的最小不满意和
 * 输入：
 * [8,9,7],[5,8,3]
 * 输出：
 * [3,1,2]
 * @date : 2020/04/12.
 */

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 生成一个2~1000的随机数
//        int n = (int) (Math.random() * (999 - 1) + 2);
        int n = 3;
        String s;

        String s1;
        String s2;
        s = sc.nextLine();
        s1 = s.substring(0, s.length() / 2 + 1);
        s2 = s.substring(s.length() / 2 + 1);
        int[] a = new int[n];
        int[] b = new int[n];
        int index = 0;
        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(j) >= '0' && s1.charAt(j) <= '9') {
                a[index++] = s1.charAt(j) - '0';
            }
        }
        index = 0;
        for (int j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) >= '0' && s2.charAt(j) <= '9') {
                b[index++] = s2.charAt(j) - '0';
            }
        }
        int[] res = new Main03().WaitInLine(a, b);
        System.out.println(Arrays.toString(res));

    }

    /**
     * 根据顾客属性计算出顾客排队顺序
     *
     * @param a int整型一维数组 顾客a属性
     * @param b int整型一维数组 顾客b属性
     * @return int整型一维数组
     */
    public int[] WaitInLine(int[] a, int[] b) {
        int[] res = new int[a.length];
        // write code here
        int[][] person = new int[a.length][2];
        for (int i = 0; i < a.length; i++) {
            person[i][0] = a[i];
            person[i][1] = b[i];
        }
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < person.length; i++) {
            map.put(person[i], i + 1);
        }
        // 先按照a数组排序，如果相等则按照b数组排序。均为从小到大
        Arrays.sort(person, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        // 查找a, b数组中对应的位置
//        int[] tmp = new int[2];
        for (int i = 0; i < a.length; i++) {
//            tmp[0] = a[i];
//            tmp[1] = b[i];
            res[i] = map.get(person[i]);
        }
        return res;
    }
}

