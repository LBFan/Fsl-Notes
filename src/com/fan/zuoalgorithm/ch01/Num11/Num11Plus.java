package com.fan.zuoalgorithm.ch01.Num11;

import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 可见的山峰对数量（进阶）
 * @date : 2019/11/10.
 */

public class Num11Plus {
    public static int getVisibleNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        // 先在环中找到其中一个最大值的位置，哪一个都行
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }

        Stack<Record> stack = new Stack<>();
        // 先把（最大值，1）这个记录放入到stack中
        stack.push(new Record(arr[maxIndex]));
        // 从最大值位置的下一个位置开始沿next方向遍历
        int index = nextIndex(maxIndex, size);
        // 用"小找大"的方式统计所有可见山峰对
        int res = 0;
        // 遍历阶段开始，当index再次回到maxIndex的时候，说明转了一圈，遍历阶段就结束
        while (index != maxIndex) {
            // 当前数字arr[index] 要进桟， 判断会不会破坏第一维数字从顶到底一依次变大
            // 如果破坏了，就依次弹出桟顶记录， 并计算山峰对数量
            while (stack.peek().value < arr[index]) {
                int k = stack.pop().times;
                // 弹出记录为（X, K), 如果K == 1, 产生2对
                // 如果K > 1,产生2*K + C（2， K)对
                res += getInternalSumm(k) + (k << 1);
            }
            // 当前数字arr[index]要进桟了，如果和当前栈顶数字一样就合并
            // 不一样就把记录（arr[index, 1]）放入桟中
            if (stack.peek().value == arr[index]) {
                stack.peek().times++;
            } else {
                stack.push(new Record(arr[index]));
            }
            index = nextIndex(index, size);
        }

        //清算阶段开始
        // 清算阶段的第1小阶段
        while (stack.size() > 2) {
            int times = stack.pop().times;
            res += getInternalSumm(times) + (times << 1);
        }

        // 清算第2小阶段
        if (stack.size() == 2) {
            int times = stack.pop().times;
            res += getInternalSumm(times) + (stack.peek().times == 1 ? times : (times << 1));
        }
        // 清算第3小阶段
        res += getInternalSumm(stack.pop().times);
        return res;
    }

    /**
     * 如果 k== 1，返回0； 如果k > 1, 返回C(2, K) (组合)
     *
     * @param k
     * @return
     */
    private static int getInternalSumm(int k) {
        return k == 1 ? 0 : (k * (k - 1) / 2);
    }

    /**
     * 环形数组中当前位置为i,数组长度为size，返回i的下一个位置
     *
     * @param i
     * @param size
     * @return
     */
    private static int nextIndex(int i, int size) {
        return i < (size - 1) ? (i + 1) : 0;
    }
}

