package com.fan.exam.jianzhioffer;

import java.util.Stack;

/**
 * @Description : 包含min函数的栈
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num30 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

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
