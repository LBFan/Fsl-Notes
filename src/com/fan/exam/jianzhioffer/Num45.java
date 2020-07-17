package com.fan.exam.jianzhioffer;

import java.util.Arrays;

/**
 * @Description : 把数组排成最小的数
 * 可以看成是一个排序问题，
 * 在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，
 * 如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num45 {
    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            str[i] = "" + numbers[i];
        }
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        for (String s : str) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
