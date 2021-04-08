package com.fan.wangzheng_shujujiegouyusuanfazhimei;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : PF_23
 * @Description : 使用链表实现LRU
 * @date : 2021/4/8 12:35.
 */
public class LRU {
    /**
     * method1:使用LinkedList和HashMap实现LRU
     * 双向链表
     */
    class Node {

        int key, value;
        Node pre, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = this;
            next = this;
        }

    }

    /**
     * LRU Cache的容量
     */
    private final int capacity;
    /**
     * dummy节点是一个冗余节点，dummy的next是链表的第一个节点，dummy的pre是链表的最后一个节点
     */
    private Node dummy;
    /**
     * 保存key-Node对，Node是双向链表节点
     */
    private Map<Integer, Node> cache;

    public LRU(int capacity) {
        this.capacity = capacity;
        cache = new ConcurrentHashMap<>();
        dummy = new Node(0, 0);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 先删除node
        remove(node);
        // 再添加node
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 先查询是否存在，存在则更新顺序，不存在则判断是否已满：已满则先删除最久未使用（头节点），然后添加；未满则直接添加
        Node node = cache.get(key);
        if (node == null) {
            // 不存在，查看缓存是否已满
            if (cache.size() >= capacity) {
                // 删除最近最久未使用的 dummy.next
                cache.remove(dummy.next.value);
                remove(dummy.next);
            }
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        } else {
            // 存在则先删除再添加
            cache.remove(node.key);
            remove(node);
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        }
    }

    /**
     * 从双向链表中删除当前节点
     *
     * @param node
     */
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 在双向链表的尾部添加节点
     *
     * @param node
     */
    private void add(Node node) {
        dummy.pre.next = node;
        node.next = dummy;
        node.pre = dummy.pre;
        dummy.pre = node;
    }

}

