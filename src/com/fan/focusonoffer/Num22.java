package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 链表中倒数第 K 个结点
 * @date : 2019/12/23.
 */

public class Num22 {

    public Node FindKthToTail(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null && k > 0) {
            cur = cur.next;
        }
        // k值＞链表的长度
        if (k > 0) {
            return null;
        }
        Node p = head;
        while (cur != null) {
            p = p.next;
            cur = cur.next;
        }
        return p;
    }
}

