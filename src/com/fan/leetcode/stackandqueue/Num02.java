package com.fan.leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 用队列实现栈
 * 在将一个元素 x 插入队列时，为了维护原来的后进先出顺序，需要让 x 插入队列首部。
 * 而队列的默认插入顺序是队列尾部，因此在将 x 插入队列尾部之后，需要让除了 x 之外的所有元素出队列，再入队列。
 * @date : 2020/02/26.
 */

public class Num02 {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }
    public boolean empty() {
        return queue.isEmpty();
    }
}

