package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/21.
 */

public class Num11 {

    public int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < str2.length; i++) {
            if (str2[i] == str1[0]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    public String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int end = 0;
        int max = 0;
//        for (int i = 0; i < chs1.length; i++) {
//            for (int j = 0; j < chs2.length; j++) {
//                if (dp[i][j] > max) {
//                    max = dp[i][j];
//                    end = i;
//                }
//            }
//        }
//        return str1.substring(end - max + 1, end + 1);
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = j;
                }
            }
        }
        return str2.substring(end - max + 1, end + 1);
    }

    /**
     * 优化的动态规划
     *
     * @param str1
     * @param str2
     * @return
     */
    public String lcst2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        // 斜线开始位置的行
        int row = 0;

        // 斜线开始位置的列
        int col = chs2.length - 1;
        // 记录最大长度
        int max = 0;
        // 最大长度更新时，记录子串的结尾位置
        int end = 0;
        while (row < chs1.length) {
            int i = row;
            int j = col;
            int len = 0;
            // 从(i,j)开始向左下方遍历
            while (i < chs1.length && j < chs2.length) {
                if (chs1[i] != chs2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                // 记录最大值，以及结束字符的位置
                if (len > max) {
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0) {
                // 斜线开始位置的列先向左移动
                col--;
            } else {
                // 列移动到最左之后，行向下移动
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }
}

