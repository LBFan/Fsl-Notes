package hanshunping.algorithm.greedy;

import java.util.*;

/**
 * @author :  PF_23
 * @Description : 贪心算法 实践场景-集合覆盖
 * 假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。 如何选择最少的广播台，让所有
 * 的地区都可以接收到信号
 * <p>
 * 思路分析:
 * 如何找出覆盖所有地区的广播台的集合呢，使用穷举法实现,列出每个可能的广播台的集合，这被称为幂集。假
 * 设总的有 n 个广播台，则广播台的组合总共有 2n -1 个,假设每秒可以计算 10 个子集，
 * <p>
 * 使用贪婪算法，效率高:
 * 1) 目前并没有算法可以快速计算得到准备的值，使用贪婪算法，则可以得到非常接近的解，并且效率高。选择
 * 策略上，因为需要覆盖全部地区的最小集合:
 * 2) 遍历所有的广播电台, 找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关
 * 系)
 * 3) 将这个电台加入到一个集合中(比如ArrayList),想办法把该电台覆盖的地区在下次比较时去掉。
 * 4) 重复第1步直到覆盖了全部的地区
 * @date : 2020/04/16.
 */

public class GreedyAlgorithm {

    public static void main(String[] args) {
        // 创建广播电视台，放入到Map
        Map<String, Set<String>> broadcasts = new HashMap<>();
        // 将各个电视台放入到broadcasts
        Set<String> hashSet1 = new HashSet<>();

        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        Set<String> hashSet2 = new HashSet<>();

        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        Set<String> hashSet3 = new HashSet<>();

        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        Set<String> hashSet4 = new HashSet<>();

        hashSet4.add("上海");
        hashSet4.add("天津");

        Set<String> hashSet5 = new HashSet<>();

        hashSet5.add("杭州");
        hashSet5.add("大连");

        // 加入到map中
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        // allAreas 存放所有的地区
        Set<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        // 创建ArrayList，存放选择的电台集合
        List<String> selects = new ArrayList<>();

        // 定义一个临时的集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        Set<String> tempSet = new HashSet<>();

        //定义给 maxKey ， 保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的 key
        //如果 maxKey 不为 null , 则会加入到 selects
        String maxKey = null;
        while (allAreas.size() != 0) {
            // 如果 allAreas 不为 0, 则表示还没有覆盖到所有的地区
            //每进行一次 while,需要
            maxKey = null;
            //遍历 broadcasts, 取出对应 key
            for (String key : broadcasts.keySet()) {
                //每进行一次 for
                tempSet.clear();
                //当前这个 key 能够覆盖的地区
                Set<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出 tempSet 和 allAreas 集合的交集, 交集会赋给 tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖地区的数量，比 maxKey 指向的集合地区还多
                // 就需要重置 maxKey
                // tempSet.size() >broadcasts.get(maxKey).size()) 体现出贪心算法的特点,每次都选择最优的
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //maxKey != null, 就应该将 maxKey 加入 selects
            if (maxKey != null) {
                selects.add(maxKey);
                //将 maxKey 指向的广播电台覆盖的地区，从 allAreas 去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        //[K1,K2,K3,K5]
        System.out.println("得到的选择结果是" + selects);
    }
}

