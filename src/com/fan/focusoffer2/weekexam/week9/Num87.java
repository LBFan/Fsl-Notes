package com.fan.focusoffer2.weekexam.week9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 恢复IP地址
 * @date : 2022/5/21 10:17.
 */

public class Num87 {
    public List<String> method(String s) {
        List<String> result = new ArrayList<>();
        helper(s, 0, 0, "", "", result);
        return result;
    }

    /**
     * @param s
     * @param i      当前数字下标
     * @param segI   第i分段
     * @param seg    当前已经恢复的的一个分段数字
     * @param ip     前i段已经恢复的IP地址
     * @param result 结果
     */
    private void helper(String s, int i, int segI, String seg, String ip, List<String> result) {

        if (i == s.length() && segI == 3 && isValidIp(seg)) {
            result.add(ip + seg);
        } else if (i < s.length() && segI <= 3) {
            char c = s.charAt(i);

            if (isValidIp(seg + c)) {
                helper(s, i + 1, segI, seg + c, ip, result);
            }

            /**
             * 当前分段长度大于0并且分段数小于4，可以新增分段IP
             */
            if (seg.length() > 0 && segI < 3) {
                // 上面的组合在一起不是一个IP段,并且当前段数在1,2,3,就可以增加一个段
                helper(s, i + 1, segI + 1, "" + c, ip + seg + ".", result);
            }
        }
    }

    /**
     * 是否是一个有效的IP段
     *
     * @param seg
     * @return
     */
    private boolean isValidIp(String seg) {

        // 意思是一个IP段的值要小于255，同时只能是0或者不能以0开头
        return Integer.parseInt(seg) <= 255 && (!seg.startsWith("0") || seg.equals("0"));
    }
}

