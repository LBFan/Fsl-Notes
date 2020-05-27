package leetcode.doublelink;

import java.util.List;

/**
 * @author :  PF_23
 * @Description : 最长子序列
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 * <p>
 * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。
 * 如果有多个相同长度的结果，返回字典序的最小字符串
 * <p>
 * 思路：
 * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，
 * 我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 * @date : 2020/01/03.
 */

public class Num07 {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;

    }

    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        String s = "abdce";
        String target = "abc";
        boolean substr = new Num07().isSubstr(s, target);
        System.out.println(substr);
    }
}

