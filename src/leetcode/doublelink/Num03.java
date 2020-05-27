package leetcode.doublelink;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author :  PF_23
 * @Description : 反转字符串中的元音字符
 * Given s = "leetcode", return "leotcede".
 * @date : 2020/01/03.
 */

public class Num03 {
    /**
     * 将所有的元音字母放在一个hashset中
     */
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}

