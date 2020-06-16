package com.fan.ctrip;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description :求最小客服人数
 * 输入一个n表示要输入的通话记录个数，接下来输入n行，每行为逗号相隔的两个整数，两个数字分别代表呼入时间和挂断时间的时间戳。
 * 举例：10,30，表示[10,30)，代表第10秒呼入，第30秒已经挂断，即第30秒可以接入新的来电；
 * 每一行都是一条通话记录，通话记录已经按呼入时间由小到大排序；
 * <p>
 * 输出一个整数；
 * <p>
 * 代表最少需要多少客服，可以满足所有旅客来电不用等待。
 * @date : 2020/04/01.
 */

public class Main01 {

    static int calcMinStaff(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        // 按照尾元素排序
        Arrays.sort(nums, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = nums[0][1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][0] >= end) {
                end = Math.min(end, nums[i][1]);
            } else {
                end = Math.min(end, nums[i][1]);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int n = in.nextInt();
//        String[][] arr = new String[n][3];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//
//                arr[i][j] = String.valueOf(in.());
//            }
//        }
        int[][] nums = new int[n][2];
        String temp = in.next();
        for (int i = 0; i < n; i++) {
            String[] ss = temp.split(",");
            nums[i][0] = Integer.parseInt(ss[0]);
            nums[i][1] = Integer.parseInt(ss[1]);
            if (i == 5) {
                break;
            }
            temp = in.next();
        }
        res = calcMinStaff(nums);
        System.out.println(res);
    }
}

