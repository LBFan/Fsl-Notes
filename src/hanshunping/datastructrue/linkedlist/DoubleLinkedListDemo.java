package hanshunping.datastructrue.linkedlist;

/**
 * @author :  PF_23
 * @Description : 双向链表实例
 * @date : 2020/03/17.
 */

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(5, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();
        System.out.println("-----------------");
        // 修改
        HeroNode2 newHeroNode = new HeroNode2(5, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();
        System.out.println("-----------------");
        // 删除
//        doubleLinkedList.del(3);
//        System.out.println("删除后的链表情况~~");
        // 按照编号插入

//        HeroNode2 newHeroNode2 = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.addByOrder(newHeroNode);
        doubleLinkedList.list();
    }
}


/**
 * 创建一个双向链表的类
 */
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 添加节点（英雄）
     */
    public void add(HeroNode2 heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助节点tmp
        HeroNode2 temp = head;
        // 找到链表的最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向最后的节点
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 插入
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode) {
        // 要找的位置是添加位置的前一个位置
        HeroNode2 cur = head;
        // 标识添加的编号是否存在
        boolean flag = false;
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.no > heroNode.no) {
                // 位置找到了，就在cur的后面插入
                break;
            } else if (cur.next.no == heroNode.no) {
                // 编号存在
                flag = true;
                break;
            }
            // 后移
            cur = cur.next;
        }

        if (flag) {
            // 不能添加，编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在了， 不能加入\n", heroNode.no);
        } else {
            // 插入
            heroNode.next = cur.next;
            cur.next = heroNode;
            if (cur.next != null) {
                heroNode.pre = cur.next.pre;
                cur.next.pre = heroNode;
            }
        }
    }

    /**
     * 修改节点的信息：和单向链表修改内容一样
     */
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 cur = head.next;
        // 表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (cur == null) {
                break;
            }
            if (cur.no == newHeroNode.no) {
                // 找到了
                flag = true;
                break;
            }
            cur = cur.next;
        }

        if (flag) {
            cur.name = newHeroNode.name;
            cur.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到节点编号为%d的节点， 不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除链表的节点
     */
    // 对于双向链表，可以直接找到要删除的节点
    public void del(int no) {

        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        // 辅助节点
        HeroNode2 cur = head.next;
        // 表示是否找到要删除的节点
        boolean flag = false;
        while (true) {
            if (cur == null) {
                // 已经找到链表的最后
                break;
            }
            if (cur.no == no) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            cur.pre.next = cur.next;
            //
            if (cur.next != null) {
                cur.next.pre = cur.pre;
            }
        } else {
            System.out.printf("要删除的节点 %d 不存在", no);
        }
    }

    /**
     * 遍历双向链表的方法
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //
        HeroNode2 cur = head.next;

        while (true) {
            if (cur == null) {
                break;
            }
            // 输出
            System.out.println(cur);
            // 后移节点
            cur = cur.next;
        }
    }
}

/**
 * 创建一个双向链表的类
 */
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


