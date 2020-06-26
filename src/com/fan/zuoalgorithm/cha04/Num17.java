package com.fan.zuoalgorithm.cha04;

/**
 * @author :  PF_23
 * @Description : 表达式得到期望结果的组成种数
 * @date : 2020/03/21.
 */

public class Num17 {

    public boolean isValid(char[] exp) {
        int len = exp.length;
        // 表达式的长度必须是奇数
        if (len % 2 == 0) {
            return false;
        }
        // 表达式下表为偶数位置的字符一定是'0'或者'1'
        for (int i = 0; i < len; i += 2) {
            if (exp[i] != '1' && exp[i] != '0') {
                return false;
            }
        }

        // 表达式下表为奇数位置的字符一定是'&'或者'|' '^'
        for (int i = 1; i < len; i += 2) {
            if (exp[i] != '&' && exp[i] != '|' && exp[i] != '^') {
                return false;
            }
        }
        return true;
    }

    public int num1(String express, boolean desired) {
        if (express == null || express.length() == 0) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return p(exp, desired, 0, exp.length - 1);
    }

    /**
     * 暴力递归
     *
     * @param exp
     * @param desired
     * @param l
     * @param r
     * @return
     */
    private int p(char[] exp, boolean desired, int l, int r) {
        if (l == r) {
            if (exp[l] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }

        int res = 0;
        // true
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        break;

                }
            }
        } else {
            // false
            for (int i = l + 1; i < r; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '^':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;

                }
            }
        }
        return res;
    }


    public int num2(String express, boolean desired) {
        if (express == null || express.length() == 0) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }

        int[][] t = new int[exp.length][exp.length];
        int[][] f = new int[exp.length][exp.length];

        t[0][0] = exp[0] == '0' ? 0 : 1;
        f[0][0] = exp[0] == '1' ? 0 : 1;

        for (int i = 2; i < exp.length; i += 2) {
            t[i][i] = exp[i] == '0' ? 0 : 1;
            t[i][i] = exp[i] == '1' ? 0 : 1;

            for (int j = i - 2; j >= 0; j -= 2) {
                for (int k = j; k < i; k += 2) {
                    if (exp[k + 1] == '&') {
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (exp[k + 1] == '|') {
                        t[j][i] += (f[j][k] + t[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i];
                    } else {
                        t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i] + t[j][k] * t[k + 2][i];
                    }
                }
            }
        }
        return desired ? t[0][exp.length - 1] : f[0][exp.length - 1];
    }


}

