package com.fan.focusoffer2.weekexam.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : LRU
 * @date : 2022/3/26 11:09.
 */

public class Num31 {

    /**
     * 头结点，虚拟节点
     */
    private ListNode head;

    /**
     * 头结点，虚拟节点
     */
    private ListNode tail;

    /**
     * 缓存队列
     */
    private Map<Integer, ListNode> queueMap;

    /**
     * 缓存容量
     */
    private int capacity;

    public Num31(int capacity) {
        queueMap = new HashMap<>();
        this.capacity = capacity;
        // 定义哨兵头结点
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);

        // 头尾相连
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (queueMap.containsKey(key)) {
            // 获取，并且将当前节点移动到最近使用的位置，本次定义在头结点的下一个节点
            ListNode listNode = queueMap.get(key);
            moveToHead(listNode);
            return listNode.value;
        }
        return -1;
    }

    private void moveToHead(ListNode listNode) {
        // 先删除当前节点在链表中的位置，然后添加到头结点
        deleteNode(listNode);
        addHead(listNode);
    }

    private void deleteNode(ListNode listNode) {
        listNode.prev.next = listNode.next;
        listNode.next.prev = listNode.prev;
    }

    public void put(int key, int value) {
        //// 如果没满，则加入并且放在头结点处，
        //if (queueMap.size() < capacity) {
        //
        //} else {
        //    // 满了，
        //    // 如果当前节点的key在队列中，则更新值，如果不在，删除尾节点，添加当前节点到头结点
        //}

        //换种思路：如果当前队列存在key,则将key的value替换，移动到头节点；如果不包含，再区分队列是否达到容量
        if (queueMap.containsKey(key)) {
            ListNode listNode = queueMap.get(key);
            // 移动当前节点到头结点
            moveToHead(listNode);
            // 更新值
            listNode.value = value;
            //queueMap.put(key, listNode);
        } else {
            if (queueMap.size() >= capacity) {
                // 删除尾节点
                ListNode last = tail.prev;
                deleteNode(last);
                // 删除队列里面的值
                queueMap.remove(last.key);
            }
            ListNode node = new ListNode(key, value);
            addHead(node);
            queueMap.put(key, node);
        }

    }


    private void addHead(ListNode node) {
        ListNode first = head.next;
        head.next = node;
        node.prev = head;
        first.prev = node;
        node.next = first;
    }

    // 定义一个双向链表：因为使用双向链表才可以在O（1）时间内增删、移动节点
    public static class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }


}

