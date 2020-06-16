package com.fan;

/**
 * @author :  PF_23
 * @Description : 左程云 p359
 * 在其他数字都出现k次的数组中找到只出现一次的数
 * @date : 2020/03/26.
 */

public class OnlyOneFromMany {

    public int onceNum(int[] arr, int k) {
        // eO是一个32位的k进制数
        int[] eO = new int[32];
        for (int i = 0; i != arr.length; i++) {
            setExclusiveOr(eO, arr[i], k);
        }
        int res = getNumFromKSysNum(eO, k);
        return res;
    }

    private void setExclusiveOr(int[] eO, int value, int k) {
        // 十进制转换为k进制
        int[] curKSysNum = getKSysNumFromNum(value, k);
        for (int i = 0; i != eO.length; i++) {
            // 无进位加
            eO[i] = (eO[i] + curKSysNum[i]) % k;
        }
    }

    /**
     * 十进制转换成K进制
     *
     * @param value
     * @param k
     * @return
     */
    private int[] getKSysNumFromNum(int value, int k) {
        int[] res = new int[32];
        int index = 0;
        while (value != 0) {
            res[index++] = value % k;
            value = value / k;
        }
        return res;
    }

    /**
     * k进制转换成十进制
     *
     * @param eO
     * @param k
     * @return
     */
    private int getNumFromKSysNum(int[] eO, int k) {
        int res = 0;
        for (int i = eO.length - 1; i != -1; i--) {
            res = res * k + eO[i];
        }
        return res;
    }

    public static void main(String[] args) {
        OnlyOneFromMany o = new OnlyOneFromMany();

        int[] num = {2, 2, 2, 4, 1, 3, 1, 3, 1, 3};
        int k = -3;
        int[] e = {1, 1, 0, 1};
//        int k = 3;

//        int[] kSysNumFromNum = o.getKSysNumFromNum(-29, -3);
//        System.out.println(kSysNumFromNum);

        int numFromKSysNum = o.getNumFromKSysNum(e, k);
        System.out.println(numFromKSysNum);
        int onceNum = new OnlyOneFromMany().onceNum(num, k);
        System.out.println(onceNum);
    }
}

