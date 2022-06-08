package com.fan.focusoffer2;

/**
 * @author : PF_23
 * @Description : 重排链表
 * @date : 2022/3/17 21:56.
 */

public class Num26 {
    /**
     * 首先将链表分成前后两个部分，然后反转后面的链表，然后组合起来
     * @param head
     * @return
     */
    public void reorderList(ListNode head) {
        // 1. 分成前后两部分 如果是奇数个，则前面的链表比后面的链表多一个，偶数个则相等
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 后半部分链表
        ListNode tmp = slow.next;

        // 断开前半部分后后半部分的连接
        slow.next = null;

        // 2. 反转后半部分
        ListNode second = reverseList(tmp);

        // 3. 组合
        ListNode first = head;
        while (second != null) {
            ListNode firNext = first.next;
            ListNode secNext = second.next;
            first.next = second;
            second.next = firNext;
            first = firNext;
            second = secNext;
        }
    }

    private ListNode reverseList(ListNode tmp) {
        ListNode pre = null;
        ListNode cur = tmp;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

