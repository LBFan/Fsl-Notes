package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 打印两个有序链表的公共部分
 * 思路：
 * 两个有序链表，一次从头结点遍历，若节点值相等，则输出；否则节点值小的节点指向下一个节点，知道其中一个链表遍历结束
 * @date : 2019/11/11.
 */

public class Num01 {
    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}

