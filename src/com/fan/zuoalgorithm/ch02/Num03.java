package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 删除链表的中间节点和a/b处的节点
 * @date : 2019/11/12.
 */

public class Num03 {

    /**
     * 删除中间节点
     *
     * @param head 头结点
     * @return 删除中间节点后的链表头结点
     */
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 删除a/b处的节点
     *
     * @param head 头结点
     * @param a    a
     * @param b    b
     * @return 删除后的链表头结点
     */
    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

}

