package com.fan.focusoffer2.weekexam.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author : PF_23
 * @Description : 插入删除，随机读取都是O(1)时间复杂度
 * @date : 2022/3/19 11:28.
 */

public class Num30 {

    // 随机是数组，插入，删除是哈希，所以需要同时shiyo8ng两种数据结构
    private Map<Integer, Integer> numToLocation;
    private ArrayList<Integer> nums;

    public Num30() {
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }

    // 插入
    public boolean insert(int val) {
        if (numToLocation.containsKey(val)) {
            return false;
        }

        // 插入:key是数值，val是数值在数组中的下标
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }

    //删除
    public boolean delete(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }


        // 删除逻辑
        int index = numToLocation.get(val);
        int size = nums.size();
        numToLocation.put(nums.get(size - 1), index);
        numToLocation.remove(val);
        nums.set(index, nums.get(size - 1));
        nums.remove(size - 1);
        return true;
    }

    //随机读取
    public int randomGet(int val) {
        Random random = new Random();
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }
}

