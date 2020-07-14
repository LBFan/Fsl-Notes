package com.fan.exam.jianzhioffer;

/**
 * @Description : 删除链表的节点 在O(1)时间内
 * @Author : shulin.fan
 * @Date : 2020/7/14
 */
public class Num18 {
    public static Node deleteNode(Node head, Node tobeDelete) {
        if (head == null || tobeDelete == null) {
            return null;
        }
        if (tobeDelete.next != null) {
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        } else {
            // 要删除的节点是尾节点
            if (head == tobeDelete) {
                // 只有一个节点
                return null;
            } else {
                // 只好遍历了
                Node cur = head;
                while (cur.next != tobeDelete) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }
}
