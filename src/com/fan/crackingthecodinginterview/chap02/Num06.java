package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;

/**
 * @Description : Palindrome: Implement a function to check if a linked list is a palindrome.
 * @Author : shulin.fan
 * @Date : 2020/6/19
 */
public class Num06 {

    /**
     * reveres and compare
     *
     * @param node node
     * @return isPalindrome ? true : false
     */
    public static boolean isPalindrome(ListNode node) {
        if (node == null || node.next == null) {
            return true;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }

        ListNode newNode = head.next;
        return isEqual(node, newNode);
    }

    private static boolean isEqual(ListNode p1, ListNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null) {
            return false;
        }
        ListNode l1 = p1, l2 = p2;
        while (l1 != null || l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    // methods 2: iterative TODO
    // methods 2: Recursive TODO
}
