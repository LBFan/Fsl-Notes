package com.fan.exam.jianzhioffer;

/**
 * @Description : 合并两个排序的链表
 * @Author : shulin.fan
 * @Date : 2020/7/15
 */
public class Num25 {
    public static ListNode mergeTwo(ListNode first, ListNode second) {
        if (first == null && second == null) {
            return null;
        }
        if (first == null || second == null) {
            return first == null ? second : first;
        }

        ListNode p1 = first, p2 = second;
        ListNode newHead = new ListNode(-1);
        ListNode listNode = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                newHead.next = p1;
                newHead = newHead.next;
                p1 = p1.next;
            } else {
                newHead.next = p2;
                newHead = newHead.next;
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            newHead.next = p1;
        }

        while (p2 != null) {
            newHead.next = p2;
        }
        return listNode.next;
    }

    public ListNode Merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        if (head1.val <= head2.val) {
            head1.next = Merge(head1.next, head2);
            return head1;
        } else {
            head2.next = Merge(head1, head2.next);
            return head2;
        }
    }
}
