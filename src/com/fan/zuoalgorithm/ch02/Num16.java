package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 单链表的选择排序
 * @date : 2019/12/03.
 */

public class Num16 {

    /**
     * 时间复杂度为O(N²),空间为O(1)
     *
     * @param head
     * @return
     */
    public static Node selectionSort(Node head) {
        // 排序部分的尾部
        Node tail = null;
        // 未排序部分的头部
        Node cur = head;
        // 未排序部分最小节点的前一个节点
        Node smallPre = null;
        // 未排序部分最小节点
        Node small = null;

        while (cur != null) {
            // 1.small = cur;
            small = cur;
            smallPre = getSmallPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail != null) {
                tail.next = small;
            } else {
                head = small;
            }
            tail = small;
        }

        return head;
    }

    private static Node getSmallPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);

        Node node = selectionSort(head);
    }
}

