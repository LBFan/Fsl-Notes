package com.fan.exam.jianzhioffer;

/**
 * @Description : 第一个只出现一次的字符
 * @Author : shulin.fan
 * @Date : 2020/7/17
 */
public class Num50 {
    /**
     * 哈希
     *
     * @param str 字符串
     * @return 第一个只出现一次的字符位置
     */
    public static int firstNotRepeatingChar(String str) {
        int[] cnt = new int[256];

        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (cnt[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
