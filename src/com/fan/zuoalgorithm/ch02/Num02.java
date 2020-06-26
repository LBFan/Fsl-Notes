package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 在单链表和双链表中删除倒数第K个节点
 * @date : 2019/11/11.
 */

public class Num02 {
    /**
     * 单链表中删除
     *
     * @param head    头节点
     * @param lastKth k
     * @return 头结点
     */
    public Node RemoveLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }

        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            // 删除cur.next节点
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * 双链表中删除
     *
     * @param head    头结点
     * @param lastKth K
     * @return 头结点
     */
    public DoubleNode RemoveLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = null;
            }
        }
        return head;
    }
}

