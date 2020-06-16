package com.fan.leetcode.everydaycoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * @date : 2020/04/09.
 */

public class TwentyTwo {

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList("()");
        }
        List<String> res = new ArrayList<>();
        // recursion
        // 开始的括号必是'('
        generate(1, n, res, "(");
        return res;
    }

    private void generate(int leftCnt, int max, List<String> res, String curr) {
        // 递归终止条件：总长已满，已到状态树最底层(叶子结点)
        if (curr.length() >= 2 * max) {
            res.add(curr);
            return;
        }
        // 左括号个数受限
        if (leftCnt < max) {
            generate(leftCnt + 1, max, res, curr + "(");
        }
        // 右括号个数 = 当前字符长度 - 左括号个数
        // rightCnt = curr.length() - leftCnt
        // rightCnt < leftCnt
        // 右比左少，必在受限max之内
        if (curr.length() < 2 * leftCnt) {
            generate(leftCnt, max, res, curr + ")");
        }
        // reverse state
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> strings = new TwentyTwo().generateParenthesis(n);
        System.out.println(strings.toString());
    }
}

