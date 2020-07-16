package com.fan.exam.jianzhioffer;

/**
 * @Description : 链表中倒数第K个节点
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num22 {
    public static Node lastKth(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
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
