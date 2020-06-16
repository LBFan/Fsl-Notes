package com.fan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 骑手分片问题 区间划分
 * 每个骑手只能在一个片段中
 * @date : 2020/03/18.
 */

public class TestMeiTuan {

    /**
     * 找出当前字符在字符串中最后出现的位置
     *
     * @param s
     * @return
     */
    public static int findLastIndex(String s) {
        char c = s.charAt(0);
        int lastIndex = s.lastIndexOf(c);
        int index;
        for (int i = 1; i < lastIndex; ++i) {
            // 遍历，找到其中每一个字符最后出现的位置
            char c1 = s.charAt(i);
            index = s.lastIndexOf(c1);
            lastIndex = lastIndex > index ? lastIndex : index;
        }
        return lastIndex + 1;
    }

    public static List<Integer> partitionLabels(String s) {
        //返回list
        List<Integer> ans = new ArrayList<>();
        //用来存储每个字母最后出现的索引
        int[] lastIndex = new int[200];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i)] = i;
        }

        //分别为每个字串开始和结尾的索引
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i)]);
            if (end == i) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "MPMPCPMCMDEFEGDEHINHKLIN";
//        String tmp = s;
//        while (tmp != null) {
//            int index = TestMeiTuan.findLastIndex(tmp);
////            System.out.print("片段长度:");
//            System.out.print(index + " ");
//            if (tmp != null && tmp.length() > index) {
//                tmp = tmp.substring(index);
//            } else {
//                break;
//            }
//        }

        List<Integer> partitionLabels = partitionLabels(s);
        System.out.println(partitionLabels.toString());


    }
}

