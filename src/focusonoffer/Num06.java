package focusonoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :  PF_23
 * @Description : 从尾到头打印链表：逆序打印链表
 * 三种方法:
 * 递归 头插 桟
 * @date : 2019/12/12.
 */

public class Num06 {
    /**
     * 递归
     *
     * @param node 原链表头节点
     * @return ret
     */
    public ArrayList<Integer> printListFromTailToHead(Node node) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (node != null) {
            // 将头结点后面的链表加入集合
            if (node.next != null) {
                ret.addAll(printListFromTailToHead(node.next));
            }
            // 结束之后将头结点加入集合
            ret.add(node.val);
        }
        return ret;
    }

    /**
     * 头插法
     *
     * @param node 原链表头节点
     * @return res
     */
    public ArrayList<Integer> printListFromTailToHead2(Node node) {
        // 头插法构建逆序链表
        Node head = new Node(-1);
        Node next;
        while (node != null) {
            next = node.next;
            node.next = head.next;
            head.next = node;
            node = next;
        }
        // 构建list
        ArrayList<Integer> res = new ArrayList<>();
        head = head.next;
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
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

