package focusonoffer;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 用两个栈实现队列:先进先出 FIFO
 * @date : 2019/12/12.
 */

public class Num09 {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
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

