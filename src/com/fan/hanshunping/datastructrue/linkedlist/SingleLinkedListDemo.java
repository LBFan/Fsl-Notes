package com.fan.hanshunping.datastructrue.linkedlist;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/17.
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
//        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
//        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
//        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入
        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        HeroNode newHero = new HeroNode(1, "宋江~", "及时雨~~");

        // 显示一把
        singleLinkedList.list();
        System.out.println("------------------");
        singleLinkedList.update(newHero);
        singleLinkedList.list();
    }
}

/**
 * 定义一个SingleLinkedList 管理我们的英雄
 */
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点（英雄）
     */
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助节点tmp
        HeroNode temp = head;
        // 找到链表的最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向最后的节点
        temp.next = heroNode;
    }

    /**
     * 插入
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        // 要找的位置是添加位置的前一个位置
        HeroNode cur = head;
        // 标识添加的编号是否存在
        boolean flag = false;
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.no > heroNode.no) {
                // 位置找到了，就在temp的后面插入
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
        }
    }

    /**
     * 修改节点的信息
     */
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode cur = head.next;
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
            // 节点后移
            cur = cur.next;
        }

        if (flag) {
            //
            cur.name = newHeroNode.name;
            cur.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到节点编号为%d的节点， 不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除链表的节点
     */

    public void del(int no) {
        HeroNode cur = head;
        // 表示是否找到要删除的节点
        boolean flag = false;
        while (true) {
            if (cur.next == null) {
                break;
            }
            if (cur.next.no == no) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            cur.next = cur.next.next;
        } else {
            System.out.printf("要删除的节点 %d 不存在", no);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //
        HeroNode cur = head.next;

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
 * 定义一个heroNode，每个heroNode对象就是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
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


