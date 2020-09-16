package com.fan.dianxin;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Description : 设计一个最小栈
 * @Author : shulin.fan
 * @Date : 2020/9/16
 */
public class Mian03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(sc.nextLine());
        }

        for (int i = 1; i <= n; i++) {
            String s = list.get(i);
            if (s.contains(" ")) {
                push(Integer.parseInt(s.split(" ")[1]));
            } else {
                switch (s) {
                    case "getMin":
                        int minRes = getMin();
                        System.out.println(minRes);
                        break;
                    case "pop":
                        pop();
                        break;
                    case "top":
                        int top = top();
                        System.out.println(top);
                        break;
                }
            }

        }
    }

    static Stack<Integer> stk = new Stack<>();
    static Stack<Integer> min = new Stack<>();

    public static void push(int x) {
        stk.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public static void pop() {
        int x = stk.pop();
        if (!min.isEmpty() && min.peek() == x) {
            min.pop();
        }
    }

    public static int top() {
        if (!stk.isEmpty()) {
            return stk.peek();
        } else {
            return 0;
        }
    }

    public static int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        } else {
            return 0;
        }
    }
}
