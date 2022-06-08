package com.fan.focusoffer2.weekexam.week1;

/**
 * @author : PF_23
 * @Description : 两数之和
 * @date : 2022/3/5 13:10.
 */

public class Num6 {

    public int[] twoSum(int[] nums, int k) {
        int i = 0, j = nums.length - 1;

        int[] res = new int[2];
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k){
                j--;
            } else {
                break;
            }
        }

        res[0] = nums[i];
        res[1] = nums[j];

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int k = 7;
        Num6 num6 = new Num6();
        int[] ints = num6.twoSum(nums, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

