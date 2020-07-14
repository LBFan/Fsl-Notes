package com.fan.exam.jianzhioffer;

/**
 * @Description : 二维数组中查找。每一行从左到右递增，每一列从上到下递增
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num04 {
    public static boolean find(int[][] nums, int target) {
        if (nums == null || nums.length <= 0 || nums[0].length <= 0) {
            return false;
        }
        // 从右上到左下
        int rows = nums.length;
        int row = 0;
        int col = nums[0].length - 1;
        while (row < rows && col >= 0) {
            int value = nums[row][col];
            if (target == value) {
                return true;
            } else if (target > value) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
