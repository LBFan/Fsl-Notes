package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 反转链表 和逆序打印思想一样
 * @date : 2019/12/23.
 */

public class Num24 {

    /**
     * 迭代头插法
     *
     * @param head
     * @return
     */
    public Node reverseNode(Node head) {
        // 边界判断
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node newHead = new Node(-1);
        while (cur != null) {
            Node next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }

    /**
     * 递归 TODO
     *
     * @param head
     * @return
     */
    public Node ReverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node next = head.next;
        head.next = null;
        Node reverseList = ReverseList(next);
        next.next = head;
        return reverseList;
    }

    /**
     * 桟
     */
}

