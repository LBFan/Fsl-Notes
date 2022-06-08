package com.fan.focusoffer2.weekexam.week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 包含K个元素的组合
 * @date : 2022/5/14 10:49.
 */

public class Num80 {

    public List<List<Integer>> subsets(int num, int k) {
        List<List<Integer>> result = new ArrayList<>();

        helper(num, 0, k, new LinkedList<>(), result);
        return result;
    }

    private void helper(int num, int index, int k, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (subset.size() == k) {
            // 组合已经有k个元素了,加入结果集后中
            result.add(new LinkedList<>(subset));
        } else if (index <= num) {
            helper(num, index + 1, k, subset, result);

            subset.add(index);
            helper(num, index + 1, k, subset, result);
            subset.removeLast();
        }

    }
}
