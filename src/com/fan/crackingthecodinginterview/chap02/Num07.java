package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;

/**
 * @Description :Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference) as
 * the jth node of the second linked list, then they are intersecting.
 * @Author : shulin.fan
 * @Date : 2020/6/20
 */
public class Num07 {
    public static ListNode findIntersection(ListNode p1, ListNode p2) {
        if (p1 == null || p2 == null) {
            return null;
        }
        // reverse
        ListNode h1 = reverse(p1);
        ListNode h2 = reverse(p2);
        if (h1.val != h2.val) {
            return null;
        }
        ListNode l1 = p1, l2 = p2;
        while (l1.next != null && l2.next != null) {
            if (l1.next.val != l2.next.val) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1.next == null ? l1 : l2;
    }

    private static ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        return head.next;
    }
}
