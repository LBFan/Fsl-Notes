package com.fan.zuoalgorithm.ch02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 将二叉搜索树转换成双向链表
 * 其实就是中序遍历
 * @date : 2019/12/03.
 */

public class Num15 {
    /**
     * 方法一：中序遍历   利用队列
     *
     * @param head 头结点
     * @return
     */
    public DNode convert1(DNode head) {
        Queue<DNode> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        DNode pre = head;
        pre.left = null;
        DNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    private void inOrderToQueue(DNode head, Queue<DNode> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

    /**
     * 方法二： 通过递归函数返回自定义数据结构
     * @param head
     * @return
     */
    public DNode convert2(DNode head) {
        if (head == null) {
            return null;
        }
        return process(head).start;
    }

    public ReturnTye process(DNode head) {
        if (head == null) {
            return new ReturnTye(null, null);
        }
        ReturnTye leftList = process(head.left);
        ReturnTye rightList = process(head.right);
        if (leftList.end != null) {
            leftList.end.right = head;
        }
        head.left = leftList.end;
        head.right = rightList.start;
        if (rightList.start != null) {
            rightList.start.left = head;
        }
        return new ReturnTye(leftList.start != null ? leftList.start : head,
                rightList.end != null ? rightList.end : head);
    }

    class DNode {
        private int value;
        private DNode left;
        private DNode right;

        DNode(int data) {
            this.value = data;
        }
    }

    class ReturnTye {
        public DNode start;
        public DNode end;

        public ReturnTye(DNode start, DNode end) {
            this.start = start;
            this.end = end;
        }
    }

}

