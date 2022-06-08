package com.fan.focusoffer2.weekexam.week1;

/**
 * @author : PF_23
 * @Description : 单词数组中最大的乘积
 * @date : 2022/3/5 12:09.
 */

public class Num5 {

    public int macProduct(String[] words) {
        int[] flag = new int[26];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                // 统计第i个字符串出现了哪些字符 ，a~z： 表示为右进制为的低位到高位 1 ~26
                flag[i] |= (1 << (c - 'a'));
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flag[i] & flag[j]) == 0) {
                    // 说明没有出现过相同的字符
                    int product = words[i].length() * words[j].length();
                    result = Math.max(product, result);
                }
            }
        }

        return result;
    }
}

