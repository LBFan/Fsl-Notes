package com.fan.kuaishou;

import java.util.*;

/**
 * @author :  PF_23
 * @Description : 判断一个数是否有幂因子，有：输出幂因子数，无:输出空 []
 * 39 = 3 + 3^2 + 3^3
 * 输出：[1,2,3]
 * @date : 2020/04/12.
 */

public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++) {
            nums[i] = Integer.parseInt(s.split(",")[i]);
        }
        Main02 m = new Main02();
        int[] powerFactor = m.GetPowerFactor(nums[0], nums[1]);
        System.out.println(Arrays.toString(powerFactor));

    }

    // 回溯
    public int[] GetPowerFactor(int R, int N) {
        List<Integer> list = new ArrayList<>();
//        list = isSub(R, N);
        int s = N;
        for (int i = 1; i < R; i++) {
            s += (N * i);
            if (s <= R) {
                list.add(i);
            } else if (s > R) {
                return new int[0];
            }
        }

        // write code here
        if (list != null || list.size() > 0) {
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }
        return new int[0];
    }

//    private List<Integer> isSub(int r, int n) {
//        // set.size90 == list.size() 可以
//
//    }
}

