package com.fan.focusoffer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/3/19 14:29.
 */

public class NumTest {
    List<String> res = new ArrayList<>();

    public List<String> kuohao(int n) {
        // le表示左括号剩余的个数，ri表示右括号表示的个数
        dfs("", n, n);
        return res;
    }

    private void dfs(String s, int le, int ri) {
        //还有几个终止条件
        if (le > ri) return;
        if (le < 0) return;
        if (le == 0 && ri == 0) {
            res.add(s);
            return;
        }
        dfs(s + "(", le - 1, ri);
        dfs(s + ")", le, ri - 1);
    }

    public static void main(String[] args) {
        NumTest numTest = new NumTest();
        List<String> kuohao = numTest.kuohao(3);
        System.out.println(kuohao);
    }
}

