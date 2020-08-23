package com.fan.meituan2020;

import java.util.*;

/**
 * @Description : 小美的跑腿代购 AC
 * 题目描述：
 * 小美的一个兼职是美团的一名跑腿代购员，她有n个订单可以接，订单编号是1~n，但是因为订单的时效性，他只能选择其中m个订单接取，精明的小美当然希望自己总的获利是最大的，已知，一份订单会提供以下信息，跑腿价格v，商品重量w kg，商品每重1kg，代购费用要加2元，而一份订单可以赚到的钱是跑腿价格和重量加价之和。小美可是开兰博基尼送货的人，所以自然不会在意自己会累这种事情。请问小美应该选择哪些订单，使得自己获得的钱最多。
 * <p>
 * 请你按照选择的订单编号的从小到大顺序，如果存在多种方案，输出订单编号字典序较小的方案。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入第一行包含两个正整数n，m，表示订单的数量和小美可以接的订单数量(1<=n,m<=10000)
 * <p>
 * 接下来有n行，第i行表示i-1号订单的信息。每行有两个正整数v和w ，表示一个订单的跑腿价格和商品重量。(1<=v,w<=1000)
 * <p>
 * 输出描述
 * 输出包含m个1~n之间的正整数，中间用空格隔开，表示选择的订单编号。
 * <p>
 * <p>
 * 样例输入
 * 5 2
 * 5 10
 * 8 9
 * 1 4
 * 7 9
 * 6 10
 * 样例输出
 * 2 5
 * @Author : shulin.fan
 * @Date : 2020/8/22
 */
public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                tmp.add(sc.nextInt());
            }
            lists.add(tmp);
        }

        List<Map.Entry<Integer, Integer>> entryList = maxSum(lists);
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = entryList.get(i).getKey();
        }
        Arrays.sort(res);
        for (Integer num : res) {
            System.out.print(num + " ");
        }
    }

    private static List<Map.Entry<Integer, Integer>> maxSum(List<List<Integer>> matrix) {
        int[] sumArr = new int[matrix.size()];
        for (int i = 0; i < matrix.size(); i++) {
            sumArr[i] = matrix.get(i).get(0) + 2 * matrix.get(i).get(1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sumArr.length; i++) {
            map.put(i + 1, sumArr[i]);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return list;
    }
}
