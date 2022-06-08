package com.fan.focusoffer2.weekexam.week3;

import static com.fan.focusoffer2.weekexam.week3.ListNode.reverseList;

/**
 * @author : PF_23
 * @Description : 重排链表
 * @date : 2022/3/19 10:50.
 */

public class Num26 {

    /**
     * 思路： 将量表分成前后两个部分，反转后半部分，重新组合成新链表
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1.拆
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 后半部分链表头结点
        ListNode second = slow.next;
        // 将前后两个部分分开
        slow.next = null;
        // 2. 反
        ListNode secondHead = reverseList(second);
        //3.合

        linkList(head, secondHead);

    }

    private void linkList(ListNode head, ListNode secondHead) {
        ListNode p1 = head, p2 = secondHead;
        while (p2 != null) {
            ListNode next = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next;

            p1 = next;
            p2 = next2;
        }
    }
}

