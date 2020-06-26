package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 向有序的环形单链表中插入新节点
 * @date : 2019/12/03.
 */

public class Num18 {

    public static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }

        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (pre.value < num && cur.value > num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }
}

