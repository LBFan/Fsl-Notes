package com.fan.exam.jianzhioffer;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 复杂链表的复制
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num35 {
    /**
     * 常规思路
     *
     * @param head 头结点
     * @return 新链表的头结点
     */
    public RandomListNode cloneLinkRandomListNode(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // cpoy
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = cur.next.next;
        }
        // copy next
        cur = head;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // 拆分 ：通过画图帮助理解
        cur = head;
        RandomListNode newHead = head.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return newHead;
    }

    public static RandomListNode copyRandomListByMap(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        return copy(head, map);
    }

    private static RandomListNode copy(RandomListNode head, Map<RandomListNode, RandomListNode> map) {
        if (head == null) {
            return head;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        RandomListNode tmp = new RandomListNode(head.label);
        map.put(head, tmp);
        tmp.next = copy(head.next, map);
        tmp.random = copy(head.random, map);
        return tmp;
    }
}