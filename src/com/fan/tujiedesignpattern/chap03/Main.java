package com.fan.tujiedesignpattern.chap03;

/**
 * @author : PF_23
 * @Description : 模板方法模式
 * @date : 2020/06/04.
 */

public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        AbstractDisplay d3 = new StringDisplay("你好，世界");
        d1.dispaly();
        d2.dispaly();
        d3.dispaly();
    }
}

