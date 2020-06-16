package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;

/**
 * @author : PF_23
 * @Description : Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 * @date : 2020/06/16.
 */

public class Num02 {

    public static ListNode findKthToLast(ListNode node, int k) {
        if (node == null) {
            return null;
        }
        ListNode cur = node;
        while (cur != null) {
            cur = cur.next;
            k--;
        }
        if (k > 0) {
            throw new RuntimeException("数字大于链表长度");
        }
        cur = node;
        while (k > 0) {
            cur = cur.next;
            k++;
        }
        return cur;
    }
}

