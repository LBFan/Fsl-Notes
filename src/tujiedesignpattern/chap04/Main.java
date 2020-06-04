package tujiedesignpattern.chap04;

import tujiedesignpattern.chap04.framework.Factory;
import tujiedesignpattern.chap04.framework.Product;
import tujiedesignpattern.chap04.idcard.IDCardFactory;

/**
 * @author : PF_23
 * @Description : 工厂方法模式测试类
 * @date : 2020/06/04.
 */

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");

        card1.use();
        card2.use();
        card3.use();
    }
}

