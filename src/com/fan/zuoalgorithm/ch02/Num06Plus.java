package com.fan.zuoalgorithm.ch02;

/**
 * @author :  PF_23
 * @Description : 时间复杂度为O(N)
 * @date : 2019/11/18.
 */

public class Num06Plus {
    public static Node josephusKill(Node head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }

        int tmp = 1;
        Node cur = head.next;
        // 计数
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }
        // 得到最后剩下的节点编码（老编码）
        tmp = getLive(tmp, m);
        while (--tmp != 0) {
            head = head.next;
        }
        // 只保留自己，其他节点不要
        head.next = head;
        return head;
    }

    private static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

}

