package com.fan.exam.jianzhioffer;

/**
 * @Description : 二叉搜索树的后序遍历序列
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num33 {
    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private static boolean verify(int[] sequence, int first, int last) {
        if (last - first < 1) {
            return true;
        }
        // 找左子树
        int i = 0;
        while (i < last && sequence[i++] < sequence[last]) {

        }
        for (int j = i; j < last; j++) {
            if (sequence[j] < sequence[last]) {
                return false;
            }
        }
        return verify(sequence, first, i - 1) && verify(sequence, i, last - 1);
    }
}