package leetcode.strings;

/**
 * @author :  PF_23
 * @Description : 字符串循环移位
 * <p>
 * 将字符串向右循环移动 k 位。
 * 将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。
 * <p>
 * s = "abcd123" k = 3
 * Return "123abcd"
 * @date : 2020/02/19.
 */

public class Num02 {
    private static String loopK(String s, int k) {
        int n = s.length();
        k = k % n;
        String start = s.substring(n - k);
        String end = s.substring(0,n - k);
        return start + end;
    }

    public static void main(String[] args) {
        int k = 3;
        String s = "abcd123";
        String s1 = loopK(s, k);
        System.out.println(s1);
    }
}

