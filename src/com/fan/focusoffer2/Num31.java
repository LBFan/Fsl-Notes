package com.fan.focusoffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : PF_23
 * @Description : 最近最少使用缓存
 * @date : 2022/3/20 21:53.
 */

public class Num31 {

    //定义变量
    /**
     * 双向链表的头结点
     */
    private ListNode head;
    /**
     * 双向链表的尾结点
     */
    private ListNode tail;

    /**
     * 缓存链表节点的哈希表
     */
    private Map<Integer, ListNode> map;
    /**
     * LRU缓存的容量（最大能存放的节点数，即哈希表的size最大为capacity）
     */
    private int capacity;

    /**
     * 初始化
     *
     * @param capacity
     */
    public Num31(int capacity) {
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    /**
     * 如果存在键key,则返回它对应的值,并且将该节点移动到链表尾部；否则返回-1
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    /**
     * 如果缓存中之前包含键key，则它的值设置为value；否则添加键key及对应的值value；
     * 在添加一个键时，如果缓存容量已经满了，则在添加新建之前删除最近使用最少的建（缓存中最长时间没有被使用过的元素）
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 先判断这个建是否存在，如果存在，则更新值,并且将该节点移动到尾节点
        if (map.containsKey(key)) {
            ListNode listNode = map.get(key);
            listNode.value = value;
            moveToTail(listNode);
        } else {
            // 不存在分两种情况：缓存满了，缓存没满
            //if (map.size() >= capacity) {
            //    // 满了就先将头结点移除，然后添加到尾节点，并且记录在map中
            //    deleteHead();
            //    ListNode node = new ListNode(key, value);
            //    addNode(node);
            //    map.put(key, node);
            //} else {
            //    // 没满：加入这个节点，放在尾节点，加入map
            //    ListNode node = new ListNode(key, value);
            //    addNode(node);
            //    map.put(key, node);
            //}

            // 简化一下：
            // 不存在分两种情况：缓存满了，缓存没满
            if (map.size() >= capacity) {
                // 满了就先将头结点移除，然后添加到尾节点，并且记录在map中
                deleteHead();
            }
            //加入这个节点，放在尾节点，加入map
            ListNode node = new ListNode(key, value);
            addNode(node);
            map.put(key, node);

        }
    }

    /**
     * 将该节点移动到尾节点，如果该节点本来就在尾节点，就不用移动
     *
     * @param node
     */
    public void moveToTail(ListNode node) {
        //首先判断当前节点是否是最后一个节点
        if (isLastNode(node)) {
            return;
        }

        // 不是最后一个节点，先删除当前节点，然后添加到尾节点
        removeNode(node);
        addNode(node);

    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        //下面这两句没必要
        //node.next = null;
        //node.prev = null;
    }

    private boolean isLastNode(ListNode node) {
        return node == tail.prev;
    }

    /**
     * 删除头节点
     */
    private void deleteHead() {
        // 删除哈希表中的头节点
        ListNode node = head.next;
        map.remove(node.key);
        // 新头节点
        ListNode next = node.next;
        head.next = next;
        next.prev = head;
        // 下面这两句没必要
        //node.next = null;
        //node.prev = null;
    }

    /**
     * 在链表中添加一个节点
     *
     * @param node
     */
    private void addNode(ListNode node) {
        // 先找出当前最后一个节点
        ListNode last = tail.prev;
        node.next = tail;
        last.next = node;
        tail.prev = node;
        node.prev = last;
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

