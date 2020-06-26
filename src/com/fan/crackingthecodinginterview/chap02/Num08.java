package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;

/**
 * @Description : Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * @Author : shulin.fan
 * @Date : 2020/6/20
 */
public class Num08 {

    public static ListNode loopDetection(ListNode node) {
        if (node == null || node.next == null) {
            return null;
        }
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        slow = node;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
