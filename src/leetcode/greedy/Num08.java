package leetcode.greedy;

/**
 * @author :  PF_23
 * @Description : 判断是否为子序列
 * s = "abc", t = "ahbgdc"
 * Return true.
 * @date : 2020/01/16.
 */

public class Num08 {

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}

