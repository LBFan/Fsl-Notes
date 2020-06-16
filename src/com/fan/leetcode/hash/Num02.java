package com.fan.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :  PF_23
 * @Description : 判断数组是否含有重复元素
 * @date : 2020/02/16.
 */

public class Num02 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num :
                nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}

