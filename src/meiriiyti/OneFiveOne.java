package meiriiyti;

import java.util.*;

/**
 * @author :  PF_23
 * @Description : 翻转字符串里的单词
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @date : 2020/04/10.
 */

public class OneFiveOne {

    public static String reverseWords(String s) {
//        // 删除首尾空格
//        s = s.trim();
//        int j = s.length() - 1, i = j;
//        StringBuilder res = new StringBuilder();
//        while (i >= 0) {
//            // 搜索首个空格
//            while (i >= 0 && s.charAt(i) != ' ') {
//                i--;
//            }
//            // 添加单词
//            res.append(s.substring(i + 1, j + 1) + " ");
//            // 跳过单词间空格
//            while (i >= 0 && s.charAt(i) == ' ') {
//                i--;
//            }
//            // j 指向下个单词的尾字符
//            j = i;
//        }
//        // 转化为字符串并返回
//        return res.toString()
//
//
//

        // 删除首尾空格，分割字符串.trim();
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= left && s.charAt(right) == ' ') {
            right--;
        }
        s = s.substring(left, right + 1);
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            // 倒序遍历单词列表
            // 遇到空单词则跳过
            if ("".equals(strs[i])) {
                continue;
            }
            // 将单词拼接至 StringBuilder
            res.append(strs[i] + " ");
        }
        // 转化为字符串，删除尾部空格，并返回
        return res.toString().trim();
    }

    private static void swap(char[] chars, int i, int j) {
        char t;
        while (i < j) {
            t = chars[i];
            chars[i++] = chars[j];
            chars[j--] = t;
        }
    }

    public static void main(String[] args) {
//        String s = "a good    example";
        String s = "  hello world!  ";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}

