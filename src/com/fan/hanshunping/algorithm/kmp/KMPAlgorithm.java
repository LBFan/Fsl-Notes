package com.fan.hanshunping.algorithm.kmp;

/**
 * @author :  PF_23
 * @Description : KMP算法
 * @date : 2020/04/16.
 */

public class KMPAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] nextArr = getNextArr(str2);
        int kmpSearch = kmpSearch(str1, str2, nextArr);
        System.out.println(kmpSearch);
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // 需要处理str1.charAt(i) != str2.charAt(j)，调整j的大小
            // KMP算法核心点！！！
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取到一个字符串（子串）的部分匹配值
    public static int[] getNextArr(String dest) {
        // 创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];

        // 如果dest是长度为1，部分匹配值就是0
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 当dest.charAt(i) != dest.charAt(j)时，我们需要从next[j - 1]获取新的j，
            // 直到当dest.charAt(i) == dest.charAt(j)满足时，才退出
            // 这是KMP算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            // 当dest.charAt(i) == dest.charAt(j)满足时，部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}

