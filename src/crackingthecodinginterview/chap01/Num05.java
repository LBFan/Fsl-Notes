package crackingthecodinginterview.chap01;

/**
 * @Description :One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 * @Author : shulin.fan
 * @Date : 2020/6/10
 */
public class Num05 {

    /**
     * @param first
     * @param second
     * @return
     */
    public static boolean oneEditWay(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        // shorter
        String s1 = first.length() <= second.length() ? first : second;
        // longer
        String s2 = first.length() <= second.length() ? second : first;

        int index1 = 0, index2 = 0;
        boolean foundDifference = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                // 如果两个字符串长度相同，那么每次比较都需要移动短字符串的指针
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                // 字符相同时，移动端字符串的指针
                index1++;
            }
            // 总是需要移动长字符串的指针
            index2++;
        }
        return true;
    }

}
