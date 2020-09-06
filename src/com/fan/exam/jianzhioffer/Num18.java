package com.fan.exam.jianzhioffer;

import java.util.concurrent.Semaphore;

/**
 * @Description : 删除链表的节点 在O(1)时间内
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num18 {
    public static Node deleteNode(Node head, Node tobeDelete) {
        if (head.val == tobeDelete.val) {
            return head.next;
        }
        Node cur = head;
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
