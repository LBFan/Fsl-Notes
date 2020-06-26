package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 反转单向和双向链表 （必须能够熟练写出来，马上写出来）
 * @date : 2019/11/12.
 */

public class Num04 {
    /**
     * 反转单链表
     *
     * @param head 头结点
     * @return 反转后的链表头结点
     */
    public Node reverseList(Node head) {
        Node pre = null;
        Node next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     *
     * @param head 头结点
     * @return 反转后的头结点
     */
    public DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            // 与单链表相比，多了这一句
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}

