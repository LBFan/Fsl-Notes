package com.fan.hanshunping.datastructrue.linkedlist;

/**
 * @author :  PF_23
 * @Description : 约瑟夫问题
 * 输出小孩出圈的顺序
 * 总结：
 * 如果需要输出每一个出圈小孩的顺序，写需要写具体的出圈过程；
 * 注意在出圈过程中指针和辅助指针的移动。通过画图 - 写代码的方式避免出错。
 * 如果只需要求出最后一个出圈的小孩，则可以使用数学公式
 * @date : 2020/04/20.
 */

public class JosepfuGame {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoy(5);
        circleLinkedList.showBoy();
        System.out.println("--------------");
        circleLinkedList.countBoy(1, 2, 5);
        ///out:
        //小孩的编号1
        //小孩的编号2
        //小孩的编号3
        //小孩的编号4
        //小孩的编号5
        //--------------
        //小孩2出圈
        //小孩4出圈
        //小孩1出圈
        //小孩5出圈
        //最后留在圈中的小孩编号为3
    }

}

/**
 * 创建一个环形单链表
 */
class CircleLinkedList {

    /**
     * 头指针
     */
    private ListNode first = null;

    /**
     * 创建环形链表
     *
     * @param nums 数组
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        /*辅助节点*/
        ListNode cur = null;
        for (int i = 1; i <= nums; i++) {
            ListNode node = new ListNode(i);
            if (i == 1) {
                // 自己指向自己
                first = node;
                first.next = node;
                cur = first;
            } else {
                // 形成一个环
                cur.next = node;
                node.next = first;
                cur = node;
            }
        }
    }

    /**
     * 显示数据
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("环形链表为空");
            return;
        }
        // 辅助节点
        ListNode cur = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", cur.no);
            if (cur.next == first) {
                // 遍历完毕!
                break;
            }
            cur = cur.next;
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入！");
            return;
        }
        // 辅助节点helper : 指向first
        ListNode helper = first;
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }
        // 报数前，让first和helper指针同时移动 k- 1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        // 出圈过程
        while (true) {
            if (helper == first) {
                /*只剩最后一个*/
                break;
            }
            // 同时移动countNum次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            // 这时first指向的节点，就是要出圈的小孩节
            System.out.printf("小孩%d出圈\n", first.no);
            // 将first指向的节点出圈
            first = first.next;
            // ！！！注意删除出圈的元素之后，helper指向出圈元素的下一个元素
            helper.next = first;
        }
        System.out.printf("最后留在圈中的小孩编号为%d", first.no);
    }
}

