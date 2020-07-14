package com.fan.exam.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description : 从尾到头打印链表 在面试过程中，如果打算修改输入的数据，一定要先问面试官是否允许修改
 * @Author : shulin.fan
 * @Date : 2020/7/13
 */
public class Num06 {

    /**
     * 递归
     *
     * @param node node
     * @return list
     */
    public ArrayList<Integer> printListFromTailToHead(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node != null) {
            if (node.next != null) {
                result.addAll(printListFromTailToHead(node.next));
            }
            result.add(node.val);
        }
        return result;
    }

    /**
     * 头插法
     *
     * @param node 原链表头节点
     * @return res
     */
    public ArrayList<Integer> printListFromTailToHead2(Node node) {
        Node head = new Node(-1);
        Node next;
        while (node != null) {
            next = node.next;
            node.next = head.next;
            head.next = node;
            node = next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        Node cur = head.next;
        while (cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }
        return result;
    }

    /**
     * 桟
     *
     * @param node 原链表头节点
     * @return res
     */
    public List<Integer> printListFromTailToHead3(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop().val);
        }
        return res;
    }
}
