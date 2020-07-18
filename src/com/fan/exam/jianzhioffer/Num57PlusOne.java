package com.fan.exam.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 和为 S 的连续正数序列
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num57PlusOne {
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum < sum) {
                end++;
                curSum += end;
            } else if (curSum > sum) {
                curSum -= start;
                start--;
            } else {
                // curSum == sum
                List<Integer> tmp = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    tmp.add(i);
                }
                if (tmp.size() != 0) {
                    res.add(tmp);
                }
                // 后后移
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return res;
    }
}
