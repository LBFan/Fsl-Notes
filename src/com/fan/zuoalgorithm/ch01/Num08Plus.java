package com.fan.zuoalgorithm.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 相对于上一题，本题加入条件 有重复元素的时候 ，依然返回左右两边最近且比自己小的元素位置
 * @date : 2019/11/06.
 */

public class Num08Plus {
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> popIndexs = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那一个
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);

                for (Integer popIndex : popIndexs) {
                    res[popIndex][0] = leftLessIndex;
                    res[popIndex][1] = i;
                }
            }
            // 元素arr[i] == arr[stack.peek().get(0)]元素
            if (!stack.isEmpty() && arr[i] == arr[stack.peek().get(0)]) {
                stack.peek().add(Integer.valueOf(i));
            } else { // arr[i] > arr[stack.peek().get(0)],则新增一个集合，然后压入栈顶
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> popIndexs = stack.pop();
            // 取位于下面位置的列表中，最晚加入的那一个
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);

            for (Integer popIndex : popIndexs) {
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = -1;
            }
        }
        return res;
    }

}

