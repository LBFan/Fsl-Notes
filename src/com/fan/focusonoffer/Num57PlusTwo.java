package com.fan.focusonoffer;

import java.util.*;

/**
 * @author :  PF_23
 * @Description : 和为 S 的连续正数序列
 * 输出所有和为 S 的连续正数序列。
 * 例如和为 100 的连续序列有：
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 * <p>
 * 滑动窗口？?
 * @date : 2019/12/31.
 */

public class Num57PlusTwo {
    public List<List<Integer>> FindContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            // 当前和小于sum
            if (curSum < sum) {
                end++;
                curSum += end;
            } else if (curSum > sum) {
                // 当前和大于sum
                curSum -= start;
                start++;
            } else {
                // 当前和等于sum
                List<Integer> tmp = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    tmp.add(i);
                }
                if (tmp.size() != 0) {
                    res.add(tmp);
                }
                // 后移
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }

        }
        return res;
    }

    /**
     * 将集合转换为二维数组
     *
     * @param result
     */
    private int[][] ListToArr(List<List<Integer>> result) {
        int[][] ret = new int[result.size()][];
        for (int i = 0; i < ret.length; i++) {
            Map m = (Map) result.get(i);
            Set set = m.keySet();
            ret[i] = new int[m.size()];
            Iterator it = set.iterator();

            for (int j = 0; it.hasNext(); j++) {
                String s = (String) it.next();
                if (m.get(s) != null) {
                    ret[i][j] = (int) m.get(s);
                }
            }
        }
        return ret;
    }

    /**
     * 比如案例：9，9 = 2 + 3 + 4 = 2 + (2+1) + (2 + 2), 9 = 4+（4+1），i个数的和是target,
     * 我们要找的条件就是target % i == 0 ，条件成立就从 3 遍历到 5 ，或者从 4 遍历到 5 ；由于我们是从后向前判断的，
     * 所以最后把数组反转一下就行了。
     *
     * @param target TODO
     * @return
     */
//    private int[][] findContinuousSequence(int target) {
//        List<int[]> res = new ArrayList<>();
//        int i = 1;
//        return ListToArr(res);
//    }
}

