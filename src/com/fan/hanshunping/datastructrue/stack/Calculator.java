package com.fan.hanshunping.datastructrue.stack;

/**
 * @author :  PF_23
 * @Description : 桟实现计算器:中缀表达式
 * 步骤：
 * 从开始扫描：
 * 1. 如果是数字，直接入数桟
 * 2. 如果是符号
 * - 2.1 如果符号栈有操作符，就进行比较,
 * -- 2.1.1 如果当前的操作符的优先级小于或者等于栈中的操作符, 就需要从数栈中 pop 出两个数,计算后结果入数桟，当前符号入符号桟
 * -- 2.1.2 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈.
 * - 2.2 如果符号桟为空，直接入符号栈
 * 3. 如果符号桟不为空，依次取出一个符号和两个数进行计算，计算完之后将结果压入数桟，直到最后符号桟为空
 * 取出数桟的唯一元素即为计算结果。
 * @date : 2020/03/17.
 */

public class Calculator {
    public static void main(String[] args) {
        // 根据思路，完成表达式的计算 处理多位数的表达式
        String expression = "3+2*6-2";
        ArrayStack2 numStack = new ArrayStack2(expression.length() / 2 + 1);
        ArrayStack2 operStack = new ArrayStack2(expression.length() / 2 + 1);
        // 用于扫描
        int index = 0;
        int num1;
        int num2;
        int oper;
        int res;
        char ch;
        // 用于拼接多位数
        String keepNum = "";
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符, 就需要从数栈中 pop 出两个数
                    //在从符号栈中 pop 出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        // 计算结果
                        res = numStack.cal(num1, num2, oper);
                        // 入栈结果
                        numStack.push(res);
                        // 入栈操作符
                        operStack.push(ch);
                    } else {
                        // 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈.
                        operStack.push(ch);
                    }
                } else {
                    //如果符号桟为空，直接入符号栈..
                    // 1 + 3
                    operStack.push(ch);
                }
            } else {
                // 如果是数，则直接入数桟
                // 1. 当处理多位数时，不能发现是一个数就立即入栈，要拼接
                // 2. 定义一个字符串用于拼接
                keepNum += ch;
                // 如果ch已经是expression的最后一位，直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.valueOf(keepNum));
                } else {
                    // 判断下一位字符是不是数字，是就继续扫描，否（运算符）则入数栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 如果后一位是运算符，入栈
                        numStack.push(Integer.valueOf(keepNum));
                        // 重要！！！重置keepNum
                        keepNum = "";
                    }
                }

            }
            // index + 1, 并判断是否扫描到表达式最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕，就顺序的从 数栈和符号栈中 pop 出相应的数和符号，并运行.
        while (true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //入栈
            numStack.push(res);
        }
        //将数栈的最后数，pop 出，就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);
    }
}

class ArrayStack2 {
    private int maxSize;

    private int[] stack;

    private int top = -1;


    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断是否桟满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断是否桟空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("桟满");
            return;
        }
        top++;
        stack[top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("桟为空");
        }
        return stack[top--];
    }

    /**
     * 遍历时需要从栈顶开始显示
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("桟空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", stack[i]);
        }
    }

    public int peek() {
        return stack[top];
    }

    /**
     * 返回运算符的优先级,程序员确定优先级
     * 数字越大，优先级就越高
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            // 假定只有加减乘除
            return -1;
        }
    }

    /**
     * 判断是否是运算符
     *
     * @param val
     * @return
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算
     *
     * @param num1 操作数2
     * @param num2 操作数1
     * @param oper 操作符
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                // 注意顺序
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                // 注意顺序
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}