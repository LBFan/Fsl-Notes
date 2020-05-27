package hanshunping.datastructrue.linkedlist;

/**
 * @author :  PF_23
 * @Description : 约瑟夫环
 * @date : 2020/03/17.
 */

public class Josepfu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否 ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        // 加入 5 个小孩节点
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        //测试一把小孩出圈是否正确
        // 2->4->1->5->3
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList {
    /**
     * 创建一个 first 节点,当前没有编号
     */
    private Boy first = null;


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
        // 辅助节点
        Boy cur = null;

        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                // 构成环
                first.setNext(first);
                // 让cur指向下一个节点
                cur = first;
            } else {
                /*形成一个环*/
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    /**
     * 遍历当前环形链表
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("环形链表为空");
            return;
        }
        // 辅助节点
        Boy cur = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", cur.getNo());
            if (cur.getNext() == first) {
                // 遍历完毕!
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入！");
            return;
        }
        // 辅助节点
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                // 说明helper指向最后的节点
                break;
            }
            helper = helper.getNext();
        }
        // 报数前，让first和helper指针同时移动 k- 1 次
        for (int j = 0; j < startNo - 1; ++j) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 出圈
        while (true) {
            if (helper == first) {
                // 说明圈中只有一个人
                break;
            }
            // 同时移动countNum次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            // 将first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号为%d", first.getNo());
    }

}

/**
 * 创建一个 Boy 类，表示一个节点
 */
class Boy {
    /**
     * 编号
     */
    private int no;
    /**
     * 指向下一个节点,默认 null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

