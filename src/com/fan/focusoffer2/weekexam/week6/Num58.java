package com.fan.focusoffer2.weekexam.week6;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author : PF_23
 * @Description : 日程表
 * @date : 2022/4/9 12:05.
 */

public class Num58 {

    private TreeMap<Integer, Integer> events;

    public boolean book(int start, int end) {
        // 小于等于当前start的最大map
        Map.Entry<Integer, Integer> event = events.floorEntry(start);
        if (event != null && event.getValue() > start) {
            return false;
        }

        // 大于等于当前start的最小map
        event = events.ceilingEntry(start);
        if (event != null && event.getKey() < end) {
            return false;
        }

        events.put(start, end);

        return true;

    }
}

