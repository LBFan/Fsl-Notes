package com.fan.exam.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description : 包含min函数的栈
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num30 {
    private Deque<Integer> dataStack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
