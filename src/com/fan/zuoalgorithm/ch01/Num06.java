package com.fan.zuoalgorithm.ch01;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 用桟来求解汉诺塔问题
 * @date : 2019/11/03.
 */

public class Num06 {

    public static int hanoiProblem1(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }

        return process(num, left, mid, right, left, right);
    }

    private static int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }

        // 如果是从左到中移动
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            // 将 1 ~ (num - 1)从左到右移动
            int part1 = process(num - 1, left, mid, right, from, another);
            // 将num从左到中移动
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            // 将1 ~ (num- 1) 从右到中移动
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            // 将 1 ~ (num - 1)从左到右移动
            int part1 = process(num - 1, left, mid, right, from, to);
            // 将num从左到中移动
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            // 将1 ~ (num- 1) 从右到左移动
            int part3 = process(num - 1, left, mid, right, to, from);
            //将num从中到右移动
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            // 将 1 ~ (num - 1)从左到右移动
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String left = "左";
        String mid = "中";
        String right = "右";
        int steps = hanoiProblem1(n, left, mid, right);
        System.out.println(steps);
    }

    // 方案二

    public enum Action {
        No, LToM, MToL, MToR, RToM
    }

    public int hanoiProblem2(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();

        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);

        for (int i = num; i > 0; i--) {
            lS.push(i);
        }

        Action[] record = {Action.No};
        int step = 0;

        while (rS.size() != num + 1) {
            step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    private int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

}

