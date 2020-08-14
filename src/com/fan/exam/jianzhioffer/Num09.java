package com.fan.exam.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description : 用两个栈实现队列
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num09 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    int size = 0;

    public Num09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.addLast(value);
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast());
            }
        }
        size--;
        return stack2.removeLast();
    }
}
