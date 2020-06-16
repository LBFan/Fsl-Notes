package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 删除链表中重复的结点 递归
 * @date : 2019/12/23.
 */

public class Num18PlusTwo {
    public Node deleteDuplication(Node pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        Node next = pHead.next;
        if (pHead.val == next.val) {
            // 结点值相等
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(next);
            return pHead;
        }
    }
}

