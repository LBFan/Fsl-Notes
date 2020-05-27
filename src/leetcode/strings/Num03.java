package leetcode.strings;

/**
 * @author :  PF_23
 * @Description : 字符串中单词的翻转
 * <p>
 * s = "I am a student"
 * Return "student a am I"
 * 将每个单词翻转，然后将整个字符串翻转。
 * 思路：
 * 先翻转每一个单词，再翻转整个字符串
 * @date : 2020/02/19.
 */

public class Num03 {
    private static void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        reverse(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length; ++i) {
            if (chas[i] != ' ') {
                l = i == 0 || chas[i - 1] == ' ' ? i : l;
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }
    }

    private static void reverse(char[] each, int lo, int hi) {
        while (lo < hi) {
            char tmp = each[lo];
            each[lo++] = each[hi];
            each[hi--] = tmp;
        }
    }
}

