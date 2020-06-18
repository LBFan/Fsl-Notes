package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;

import java.util.List;

/**
 * @author : PF_23
 * @Description : Delete Middle Node: Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list,
 * given only access to that node.
 * EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e- >f
 * @date : 2020/06/18.
 */

public class Num03 {

    public ListNode delMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode fast = head.next.next, slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = head;
        while (cur.next != slow) {
            cur = cur.next;
        }
        cur.next = slow.next;
        return head;
    }
}

