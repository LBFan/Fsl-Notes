package com.fan.exam.jianzhioffer;

/**
 * @Description : 删除链表的节点 在O(1)时间内
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num18 {
    public static ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head.val == tobeDelete.val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val == tobeDelete.val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
