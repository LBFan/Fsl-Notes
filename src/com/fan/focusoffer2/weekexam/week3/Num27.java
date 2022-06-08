package com.fan.focusoffer2.weekexam.week3;

import static com.fan.focusoffer2.weekexam.week3.ListNode.reverseList;

/**
 * @author : PF_23
 * @Description : 回文链表: 多种解法： 反转链表；分成两部分；桟；此处用分成两部分（注意链表个数有奇数个和偶数个的情况）
 * @date : 2022/3/19 11:02.
 */

public class Num27 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 分
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

        //3.比
        return containsList(head, secondHead);
    }

    private boolean containsList(ListNode head, ListNode secondHead) {
        ListNode p1 = head, p2 = secondHead;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}

