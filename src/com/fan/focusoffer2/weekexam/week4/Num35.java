package com.fan.focusoffer2.weekexam.week4;

import java.util.List;

/**
 * @author : PF_23
 * @Description : 最小时间差
 * @date : 2022/3/26 12:55.
 */

public class Num35 {

    public int minTime(List<String> timePoints) {
        // 使用一个数组替换哈希，存放每个时刻是否出现，然后计算相邻时间差，求出最小值
        if (timePoints.size() <= 0 || timePoints.size() > 1440) {
            // 为空或者超出了最大的一天时刻数说明有重复，直接返回最短时间差0
            return 0;
        }

        boolean[] countTime = new boolean[1440];
        for (String time : timePoints) {
            String[] split = time.split(":");
            int timer = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            if (countTime[timer]) {
                // 有重复值，直接返回最短时间差0
                return 0;
            }
            countTime[timer] = true;
        }

        int minTime = 1440;
        int pre = -1;
        int first = 1440;
        int last = -1;

        for (int i = 0; i < countTime.length; i++) {
            if (countTime[i]) {
                if (pre >= 0) {
                    // 说明有两个相邻出现的时刻了,计算
                    minTime = Math.min(minTime, i - pre);
                }
                pre = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }

        return Math.min(minTime, first + 1440 - last);
    }
}

