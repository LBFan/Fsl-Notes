package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 一种怪异的节点删除方式
 * @date : 2019/12/03.
 */

public class Num17 {

    public static void removeNodeWired(Node node) {
        if (node == null) {
            return;
        }
        Node next = node.next;
        if (next == null) {
            throw new RuntimeException("can not remove last node.");
        }
        node.value = next.value;
        node.next = next.next;
    }
}

