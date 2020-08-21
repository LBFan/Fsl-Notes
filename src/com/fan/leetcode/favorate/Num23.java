package com.fan.leetcode.favorate;

/**
 * @Description :外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * <p>
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * <p>
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * <p>
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * <p>
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * @Author : shulin.fan
 * @Date : 2020/8/19
 */
public class Num23 {
    /**
     * 找规律
     *
     * @param n 第N个数
     * @return 结果
     */
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n; ++i) {
            //遍历前一个字符串
            String curStr = new String(ans);
            ans.delete(0, ans.length());
            int count = 0;
            char curChar = curStr.charAt(0);
            for (char c : curStr.toCharArray()) {
                if (c == curChar) {
                    count++;
                } else {
                    ans.append((char) ('0' + count));
                    ans.append(curChar);
                    curChar = c;
                    count = 1;
                }
            }
            ans.append((char) ('0' + count));
            ans.append(curChar);

        }
        return ans.toString();
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static String countAndSayRec(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }

        StringBuilder res = new StringBuilder();
        // 上一次的结果
        String s = countAndSayRec(n - 1);
        int length = s.length();
        int start = 0;
        for (int i = 1; i <= length; i++) {
            if (i == length) {
                // 已经到最后了
                res.append(i - start).append(s.charAt(start));
            } else if (s.charAt(start) != s.charAt(i)) {
                res.append(i - start).append(s.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 5;
        String andSayRec = countAndSayRec(n);
        System.out.println(andSayRec);
    }

}
