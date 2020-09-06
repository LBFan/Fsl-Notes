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
     * @param listNode node
     * @return list
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            if (listNode.next != null) {
                result.addAll(printListFromTailToHead(listNode.next));
            }
            result.add(listNode.val);
        }
        return result;
    }

    /**
     * 头插法
     *
     * @param listNode 原链表头节点
     * @return res
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode head = new ListNode(-1);
        ListNode next;
        while (listNode != null) {
            next = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        ListNode cur = head.next;
        while (cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }
        return result;
    }

    /**
     * 桟
     *
     * @param listNode 原链表头节点
     * @return res
     */
    public List<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }

        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop().val);
        }
        return res;
    }
}
