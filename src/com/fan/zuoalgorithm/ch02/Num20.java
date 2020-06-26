package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 按照左右半区的形式重新组合单链表
 * @date : 2019/12/03.
 */

public class Num20 {

    public static void relocate(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node mid = head;
        Node right = head.next;
        // find the mid
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        // right为右半区的第一个节点
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
    }

    private static void mergeLR(Node left, Node right) {
        Node next;
        // 画图理解组合过程
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }
}

