package com.fan.focusoffer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author : PF_23
 * @Description : 插入、删除和随机访问都是O(1)的容器
 * @date : 2022/3/17 22:51.
 */

public class Num30 {

    HashMap<Integer, Integer> numToLocation;
    ArrayList<Integer> nums;

    public Num30() {
        nums = new ArrayList<>();
        numToLocation = new HashMap<>();
    }

    public boolean insert(int val) {
        if (numToLocation.containsKey(val)) {
            return false;
        }

        // 先存哈希，再保存在数组中
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }

        // 删除哈希表中该元素，删除数组中该元素，返回true
        int index = numToLocation.get(val);

        // 将哈希中最后放入的数放在数组位置为index处
        numToLocation.put(nums.get(nums.size() - 1), index);
        numToLocation.remove(val);
        // 将最后一个数字放在index处，并且删除最后一个数字
        nums.set(index, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);

        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int r = random.nextInt(nums.size());
        return nums.get(r);
    }
}

