package com.fan.crackingthecodinginterview.chap02;

import com.fan.util.ListNode;

/**
 * @Description : Sum Lists: You have two numbers represented by a linked list,where each node contains a single digit. The digits are stored in reverse order,such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output:2 -> 1 -> 9.Thatis,912.
 * @Author : shulin.fan
 * @Date : 2020/6/19
 */
public class Num05 {

    public static ListNode sumList(ListNode p1, ListNode p2, int carry) {
        if (p1 == null || p2 == null || carry == 0) {
            return null;
        }

        ListNode result = new ListNode(-1);
        int value = carry;
        if (p1 != null) {
            value += p1.val;
        }
        if (p2 != null) {
            value += p2.val;
        }

        result.val = value % 10;
        ListNode more = sumList(p1 == null ? null : p1.next, p2 == null ? null : p2.next, value >= 10 ? 1 : 0);
        result.next = more;
        return result;
    }
}
