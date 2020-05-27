package jvm.cha02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 运行时常量池导致的内存溢出异常
 * --XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * @date : 2020/04/07.
 */

public class Six {
    public static void main(String[] args) {
        //使用List保持着常量池的引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        // 10MB的permSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

