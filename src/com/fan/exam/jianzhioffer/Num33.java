package com.fan.exam.jianzhioffer;

/**
 * @Description : 二叉搜索树的后序遍历序列
 * 判断哪是否是一颗二叉搜索树的后序遍历
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num33 {
    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            // pay attention!!!
            return true;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private static boolean verify(int[] sequence, int first, int last) {
        if (first >= last) {
            return true;
        }
        // 找左子树
        int index = 0;
        while (index < last && sequence[index++] < sequence[last]) {

        }
        for (int j = index; j < last; j++) {
            if (sequence[j] < sequence[last]) {
                return false;
            }
        }
        return verify(sequence, first, index - 1) && verify(sequence, index, last - 1);
    }
}
