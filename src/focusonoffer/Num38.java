package focusonoffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 字符串的排列
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，
 * 则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 * <p>
 * 解题思路
 * @date : 2019/12/25.
 */

public class Num38 {
    private static ArrayList<String> ret = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] hasUsed = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            backtracking(chars, hasUsed, new StringBuilder());
        }
        return ret;
    }

    private static void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            // 组成一个组合了,加入集合后返回
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            if (i != 0 && chars[i] == chars[i - 1] && hasUsed[i - 1]) {
                /* 保证不重复 */
                continue;
            }
            s.append(chars[i]);
            hasUsed[i] = true;
            backtracking(chars, hasUsed, s);
            // 回溯上一个字符
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        String string = "aab";
        ArrayList<String> permutation = Permutation(string);
        System.out.println(permutation.toString());
    }
}

