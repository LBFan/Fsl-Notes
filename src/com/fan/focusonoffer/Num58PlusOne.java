package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 翻转单词顺序列
 * Input:
 * "I am a student."
 * Output:
 * "student. a am I"
 * <p>
 * 思路：
 * 第一次翻转每一个非空字符串，第二次翻转全部非空字符串
 * 题目应该有一个隐含条件，就是不能用额外的空间。虽然 Java 的题目输入参数为 String 类型
 * ，需要先创建一个字符数组使得空间复杂度为 O(N)，但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。
 * 任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
 * <p>
 * 正确的解法应该是和书上一样，先旋转每个单词，再旋转整个字符串。
 * @date : 2019/12/31.
 */

public class Num58PlusOne {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;

        // 此处两个变量用来控制每个字符串的起始位置和终止位置
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);

    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}

