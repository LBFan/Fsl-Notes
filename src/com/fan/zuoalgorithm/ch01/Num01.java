package com.fan.zuoalgorithm.ch01;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 设计一个有getMin功能的桟
 * 用两个桟来解答 一个桟为正常桟，另一个为（栈顶）存放最小值的桟
 * @date : 2019/11/03.
 */

public class Num01 {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

//    public Num01() {
//        stackData = new Stack<>();
//        stackMin = new Stack<>();
//    }

    // 方案一

    /**
     * 插入操作
     *
     * @param newNum 待插入的数
     */
    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= getMin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    /**
     * @return 栈顶元素
     */
    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException(("Your Stack is empty."));
        }
        int value = stackData.pop();
        // 若弹出的值是最小值，同步弹出
        if (value == getMin()) {
            stackMin.pop();
        }
        return value;
    }

    /**
     * 获取最小值
     *
     * @return 最小值
     */
    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }

    /*--------------------------------------------------------*/
    // 方案二

    /**
     * 插入操作，同步两个桟的元素个数
     *
     * @param newNum 待插入的数
     */
    public void push02(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum < getMin()) {
            stackMin.push(newNum);
        } else { // 当压入元素大于最小值时，最小值桟再次压入当前栈顶元素，保持与正常桟元素个数一致
            int newMin = stackMin.peek();
            stackMin.push(newMin);
        }
        stackData.push(newNum);
    }

    /**
     * @return 栈顶元素
     */
    public int pop02() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        // 同步两个桟的元素个数
        stackMin.pop();
        return stackData.pop();
    }

    /**
     * 获取最小值
     *
     * @return 最小值
     */
    public int getMin02() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }
}

