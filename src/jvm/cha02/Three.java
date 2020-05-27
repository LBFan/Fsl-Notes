package jvm.cha02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : 堆内存溢出异常测试
 * @date : 2020/04/07.
 */

public class Three {
    static class OOMObject {

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}

