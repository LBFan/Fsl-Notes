package com.fan.focusoffer2.weekexam.week3;

/**
 * @author : PF_23
 * @Description : 排序的循环链表
 * @date : 2022/3/19 11:19.
 */

public class Num29 {
    // 循环链表是大小排序的，插入到顺序的位置
    public ListNode insertVal(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            head.next = head;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }

    private void insertCore(ListNode head, ListNode node) {
        ListNode cur = head;
        ListNode biggest = head;
        ListNode next = head.next;
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }

        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;
        } else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}

