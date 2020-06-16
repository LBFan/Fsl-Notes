package com.fan.hanshunping.algorithm.dac;

/**
 * @author :  PF_23
 * @Description : 分治算法 Divide-and-Conquer(P)
 * 分治法在每一层递归上都有三个步骤:
 * 1) 分解:将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题
 * 2) 解决:若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题
 * 3) 合并:将各个子问题的解合并为原问题的解
 * 分治算法最佳实践-汉诺塔
 * <p>
 * 汉诺塔游戏的演示和思路分析:
 * 1) 如果是有一个盘， A->C
 * 如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的盘 2. 上面的盘
 * 2) 先把最上面的盘A->B
 * 3) 把最下边的盘 A->C
 * 4) 把B塔的所有盘从B->C
 * @date : 2020/04/16.
 */

public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        // 如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            // num >= 2
            // 1. 先把最上面的所有盘A->B, 移动过程中会使用C
            hanoiTower(num - 1, a, c, b);
            // 2. 把最下边的盘 A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            // 3. 把最上面的所有盘B->C, 移动过程中会使用A
            hanoiTower(num - 1, b, a, c);
        }
    }

}

