package com.fan.hanshunping.datastructrue.hashtab;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 哈希表
 * 有一个公司,当有新的员工来报道时,要求将该员工的信息加入(id,性别,年龄,名字,住址..),当输入该员工的 id 时,
 * 要求查找到该员工的 所有信息.
 * 要求:
 * 1) 不使用数据库,,速度越快越好=>哈希表(散列)
 * 2) 添加时，保证按照 id 从低到高插入 [课后思考:如果 id 不是从低到高插入，但要求各条链表仍是从低到
 * 高，怎么解决?]
 * 3) 使用链表来实现哈希表, 该链表不带表头[即: 链表的第一个结点就存放雇员信息]
 * @date : 2020/04/15.
 */

public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(4);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入 id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的 id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

/**
 * 创建 HashTab 管理多条链表
 */
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    /**
     * 表示有多少条链表
     */
    private int size;
    //构造器

    public HashTab(int size) {
        this.size = size;
        //初始化 empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //?留一个坑,
        // 这时不要忘记分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     *
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工的 id ,得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将 emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    /**
     * 遍历所有的链表,遍历
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 根据输入的 id,查找雇员
     *
     * @param id ID
     */
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp != null) {
            //找到
            System.out.printf("在第%d 条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    /**
     * 编写散列函数, 使用一个简单取模法
     *
     * @param id id
     * @return 链表应该在的位置
     */
    public int hashFun(int id) {
        return id % size;
    }

}

/**
 * 创建 EmpLinkedList ,表示链表
 */
class EmpLinkedList {
    /**
     * 头指针，执行第一个 Emp,因此我们这个链表的 head 是直接指向第一个 Emp
     * 默认为null
     */
    private Emp head;

    //添加雇员到链表
    //说明
    //1. 假定，当添加雇员时，id 是自增长，即 id 的分配总是从小到大
    // 因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no) {
        if (head == null) {
            //说明链表为空
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        //辅助指针
        Emp curEmp = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                //说明 curEmp 已经是最后结点
                break;
            }
            //后移，遍历
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    /**
     * 如果查找到，就返回 Emp, 如果没有找到，就返回 null
     *
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        //辅助指针
        Emp curEmp = head;
        while (true) {
            // 找到了
            if (curEmp.id == id) {
                break;
            }
            //说明遍历当前链表没有找到该雇员
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

/**
 * 表示一个雇员
 */
class Emp {
    public int id;
    public String name;
    /**
     * next 默认为 null
     */
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

