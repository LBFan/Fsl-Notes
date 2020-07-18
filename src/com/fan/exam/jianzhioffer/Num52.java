package com.fan.exam.jianzhioffer;

/**
 * @Description : 两个链表的第一个公共节点
 * @Author : shulin.fan
 * @Date : 2020/7/18
 */
public class Num52 {
    public Node findFirstCommonNode(Node pHead1, Node pHead2) {
        Node l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    /**
     * 逆序法
     *
     * @param p1
     * @param p2
     * @return
     */
    public static Node firstPublicNode(Node p1, Node p2) {
        Node l1 = reverse(p1);
        Node l2 = reverse(p2);
        while (l1.next != null && l2.next != null) {
            if (l1.next != l2.next) {
                return l1;
            }
        }
        return null;
    }

    private static Node reverse(Node node) {
        Node newHead = new Node(-1);
        Node cur = node;
        while (cur != null) {
            Node next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead;
    }
}
