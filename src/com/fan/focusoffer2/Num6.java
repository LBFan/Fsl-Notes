package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/3 22:05.
 */

public class Num6 {
    public int maxProduct(String[] words) {
        int min = Integer.MAX_VALUE;
        boolean[][] flag = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flag[i][c - 'a'] = true;
            }
        }

        // 对比每一对可能的字符串，如果都没有出现相同的字符，就计算，并且比较大小，取小的值
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                while (k < 26) {
                    if (flag[i][k] && flag[j][k]) {
                        break;
                    }
                    k++;
                }
                if (k == 26) {
                    int product = words[i].length() * words[j].length();
                    min = Math.min(min, product);
                }
            }
        }
        return min;
    }
}


