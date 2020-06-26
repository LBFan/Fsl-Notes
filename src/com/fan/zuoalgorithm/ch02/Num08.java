package com.fan.zuoalgorithm.ch02;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description :将单向链表按某值划分成左边小、中间相等、右边大的形式
 * @date : 2019/11/19.
 */

public class Num08 {
    /**
     * O(N)、O(N)解法
     *
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition1(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        // 将链表放入一个数组中，调整
        Node cur = head;
        int i = 0;
        while (cur != null) {
            ++i;
            cur = cur.next;
        }
        Node[] arr = new Node[i];
        cur = head;
        i = 0;
        while (cur != null) {
            arr[i++] = cur;
            cur = cur.next;
        }
        arrPartition(arr, pivot);
        for (int j = 1; j < arr.length; j++) {
            arr[j - 1].next = arr[j];
        }
        arr[i - 1].next = null;
        return arr[0];
    }

    private static void arrPartition(Node[] arr, int pivot) {
        int small = -1;
        int big = arr.length;
        int index = 0;
        while (index != big) {
            if (arr[index].value < pivot) {
                swap(arr, ++small, index++);
            } else if (arr[index].value == pivot) {
                index++;
            } else {
                swap(arr, --big, index);
            }
        }
    }

    private static void swap(Node[] arr, int i, int index) {
        Node tmp = arr[i];
        arr[i] = arr[index];
        arr[index] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        // 小的头
        Node sH = null;
        // 小的尾
        Node sT = null;
        // 相等的头
        Node eH = null;
        // 相等的尾
        Node eT = null;
        // 大的头
        Node bH = null;
        // 大的尾
        Node bT = null;
        // 保存下一个节点
        Node next = null;
        // 所有的节点分进三个链表
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                // 小为空
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // 小的和相等的重新连接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // 所有的重新连接
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void main(String[] args) {
        Node node = new Node(9);
        Node node2 = new Node(0);
        Node node3 = new Node(5);
        Node node4 = new Node(4);
        Node node5 = new Node(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        int pivot = 3;
        Node node1 = listPartition1(node, pivot);

        Queue q = new PriorityQueue();
    }
}

