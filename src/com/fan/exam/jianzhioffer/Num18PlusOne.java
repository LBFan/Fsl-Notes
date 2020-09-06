package com.fan.exam.jianzhioffer;

/**
 * @Description :删除链表中重复的结点 递归
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num18PlusOne {
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }
}
