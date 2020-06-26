package com.fan.zuoalgorithm.ch02;

import java.util.HashSet;

/**
 * @author :  PF_23
 * @Description : 删除无序链表中的重复值节点
 * @date : 2019/12/02.
 */

public class Num13 {

    /**
     * method one : hashSet
     * @param head
     */
    public void removeRep1(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    /**
     * method two: O(N²)
     * @param head
     */
    public void removeRep2(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node pre;
        Node next;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}

