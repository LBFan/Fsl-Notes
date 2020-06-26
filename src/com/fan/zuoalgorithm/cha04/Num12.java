package com.fan.zuoalgorithm.cha04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 子数组异或和为0的最多划分
 * @date : 2020/03/21.
 */

public class Num12 {
    public int mostEOR(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int eor = 0;
        // dp[i]含义是如果在arr[0..i]上做分割，异或和为0的子数组最多能有多少个。
        int[] dp = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        dp[0] = arr[0] == 0 ? 1 : 0;
        map.put(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            eor ^= arr[i];
            if (map.containsKey(eor)) {
                int preEorIndex = map.get(eor);
                dp[i] = preEorIndex == -1 ? 1 : (dp[preEorIndex] + 1);
            }
            // 两种情况的较大值
            dp[i] = Math.max(dp[i - 1], dp[i]);
            // 存放eor和value键值对；要是之前存放过key为eor的值得键值对，更新值
            map.put(eor, i);
        }
        return dp[dp.length - 1];
    }
}

