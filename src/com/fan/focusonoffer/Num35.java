package com.fan.focusonoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description : 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的 head。
 * @date : 2019/12/25.
 */

public class Num35 {
    //    public RandomListRandomListNode cloneLinkRandomListNode(RandomListRandomListNode head) {
//        if (head == null) {
//            return null;
//        }
//        // 插入新节点
//        RandomListRandomListNode cur = head;
//        while (cur != null) {
//            RandomListRandomListNode clone = new RandomListRandomListNode(cur.label);
//            clone.next = cur.next;
//            cur.next = clone;
//            cur = cur.next.next;
//        }
//        // 建立 random 链接
//        cur = head;
//        while (cur != null) {
//            RandomListRandomListNode clone = cur.next;
//            if (cur.random != null) {
//                clone.random = cur.random.next;
//            }
//            cur = clone.next;
//        }
//
//        // 拆分
//        cur = head;
//        RandomListRandomListNode newHead = head.next;
//        while (cur.next != null) {
//            RandomListRandomListNode next = cur.next;
//            cur.next = next.next;
//            cur = next;
//        }
//        return newHead;
//    }

    Map<RandomListNode, RandomListNode> map = new HashMap();

    public RandomListNode copyRandomListByMap(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        return copy(head, map);
    }

    private RandomListNode copy(RandomListNode node, Map<RandomListNode, RandomListNode> map) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        RandomListNode tmp = new RandomListNode(node.label);
        map.put(node, tmp);
        tmp.next = copy(node.next, map);
        tmp.random = copy(node.random, map);
        return tmp;

    }
}

