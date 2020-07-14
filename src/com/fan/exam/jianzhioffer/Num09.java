package com.fan.exam.jianzhioffer;

import java.util.Stack;

/**
 * @Description : 用两个栈实现队列
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num09 {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return out.pop();
    }
}
