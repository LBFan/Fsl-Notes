package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 反转部分单链表
 * @date : 2019/11/18.
 */

public class Num05 {
    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        //获取反转起始节点的前一个节点
        Node fPre = null;
        //获取反转结束节点的后一个节点
        Node tPos = null;

        while (node1 != null) {
            len++;
            //找到反转起始节点的前一个节点
            fPre = len == from - 1 ? node1 : fPre;
            //找到反转结束节点的后一个节点
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        // node1 ： 反转链的起始点
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        //起始反转的节点指向反转结束节点的后一个节点
        node1.next = tPos;
        Node next;
        // ************反转链表的核心代码********
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        // ***********************************
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    //打印链表
    public static void PrintList(Node head)
    {
        while(head!=null)
        {

            System.out.print(head.value+" ");
            head=head.next;
        }

        System.out.println();

    }
    public static void main(String []args)
    {

        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);

        System.out.println("反转部分链表前：");
        PrintList(node);
        //反转节点2---4
        Node mode=reversePart(node,2,4);
        System.out.println("反转部分链表后：");
        PrintList(mode);
    }
}

