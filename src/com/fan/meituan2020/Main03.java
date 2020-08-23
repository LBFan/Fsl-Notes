package com.fan.meituan2020;

import java.util.*;

/**
 * @Description :小美的仓库整理
 * 题目描述：
 * 小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。已知货物入库的时候是按顺序堆放在一起的。如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，这样可以保证货物局部的顺序不变。
 * <p>
 * 已知货物最初是按1~n的顺序堆放的，每件货物的重量为w_i,小美会根据单据依次不放回的取出货物。请问根据上述操作，小美每取出一件货物之后，重量和最大的一堆货物重量是多少？
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入第一行包含一个正整数n，表示货物的数量。(1<=n,m<=50000)
 * <p>
 * 输入第二行包含n个正整数，表示1~n号货物的重量w_i。(1<=w_i<=100)
 * <p>
 * 输入第三行有n个数，表示小美按顺序取出的货物的编号，也就是一个1~n的全排列。
 * <p>
 * 输出描述
 * 输出包含n行，每行一个整数，表示每取出一件货物以后，对于重量和最大的一堆货物，其重量和为多少。
 * <p>
 * <p>
 * 样例输入
 * 5
 * 3 2 4 4 5
 * 4 3 5 2 1
 * 样例输出
 * 9
 * 5
 * 5
 * 3
 * 0
 * @Author : shulin.fan
 * @Date : 2020/8/22
 */
public class Main03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            order[i] = sc.nextInt();
        }

        List<Long> list = weightSum(weight, order);
        list.forEach(System.out::println);
    }

    private static List<Long> weightSum(int[] weight, int[] order) {
        List<Long> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int len = order.length;
        for (int i = 0; i < len; i++) {
            deque.addLast(order[i]);
            int[] tmp = new int[deque.size()];
            int index = 0;
            for (Integer num : deque) {
                tmp[index++] = num;
            }
            Arrays.sort(tmp);
            int pre = -1;
            long max = 0;
            for (int j = 0; j < tmp.length; j++) {
                long result = 0;
                int cur = tmp[j] - 1;
                for (int k = pre + 1; k < cur; k++) {
                    result += weight[k];
                }
                pre = cur;
                max = Math.max(max, result);
            }
            long ans = 0;
            for (int j = pre + 1; j < len; j++) {
                ans += weight[j];
                max = Math.max(max, ans);
            }
            res.add(max);
        }
        return res;
    }
}
