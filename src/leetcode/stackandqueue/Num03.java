package leetcode.stackandqueue;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 最小值桟
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * @date : 2020/02/26.
 */

public class Num03 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public int pop() {
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        return dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

