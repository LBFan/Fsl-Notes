package com.fan.exam.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description : 和为 S 的连续正数序列
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num57PlusOne {
    /**
     * 常规 （滑动窗口）
     *
     * @param sum
     * @return
     */
    public List<List<Integer>> findContinuousSequenceNormal(int sum) {
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

    /**
     * 优化
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        // n代表能组成和为target的连续数字个数
        int n = 1;
        while (target > 0) {
            target -= n++;
            if (target > 0 && target % n == 0) {
                int[] tmp = new int[n];
                int start = target / n;
                for (int i = 0; i < n; ++i) {
                    tmp[i] = start++;
                }
                list.add(tmp);
            }
        }
        Collections.reverse(list);
        return list.toArray(new int[0][]);
    }
}
