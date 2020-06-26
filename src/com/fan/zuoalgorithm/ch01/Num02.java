package com.fan.zuoalgorithm.ch01;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 由两个桟组成队列
 * @date : 2019/11/03.
 */

public class Num02 {
    public Stack<Integer> stackPush = new Stack<>();
    public Stack<Integer> stackPop = new Stack<>();

    public void pushToPop() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty.");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty.");
        }
        pushToPop();
        return stackPop.peek();
    }
}

