package com.fan.focusoffer2.weekexam.week9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 生成匹配的括号
 * @date : 2022/5/21 10:17.
 */

public class Num85 {
    public List<String> method(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, "", result);
        return result;
    }

    private void helper(int left, int right, String tmpStr, List<String> result) {
        if (left == 0 && right == 0) {
            // 说明左右都匹配完了
            result.add(tmpStr);

            // 匹配结束
            //return;
        }

        if (left > 0) {
            // 说明左括号还没有匹配完成，可以添加
            helper(left - 1, right, tmpStr + "(", result);
        }

        if (right > left) {
            //说明当前右括号少于左括号，可以添加右括号
            helper(left, right - 1, tmpStr + ")", result);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        Num85 num85 = new Num85();
        List<String> method = num85.method(n);
        System.out.println(method);
    }
}

