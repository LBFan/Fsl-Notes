package com.fan.hanshunping.datastructrue.queue;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 数组模拟环形队列
 * 可以循环使用
 * @date : 2020/03/17.
 */

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        // 测试数据模拟环形队列 :
        // 设置maxsize = 4,有效个数为3
        CircleArray queue = new CircleArray(4);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("S(show): 显示队列");
            System.out.println("E(exit): 退出程序");
            System.out.println("A(add): 添加数据到队列");
            System.out.println("G(get): 获取数据");
            System.out.println("H(head): 显示队列头部元素");
            // 接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 'S':
                    queue.showQueue();
                    System.out.println();
                    break;
                case 'A':
                    System.out.println("输入一个数");
                    int val = scanner.nextInt();
                    queue.addQueue(val);
                    break;
                case 'G':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据时%d", res);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'H':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头得数据是%d", res);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'E':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~~");
    }
}

class CircleArray {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队列头 ： 指向队列头部， 分析出front是指向队列头的数据
     */
    private int front;

    /**
     * 队列尾 ： 指向队列尾的数据的后一个位置
     */
    private int rear;

    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        /*判满条件：(rear + 1) % maxSize == front*/
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        /*判空条件：rear == front*/
        return rear == front;
    }

    public void addQueue(int val) {
        if (isFull()) {
            System.out.println("队列满，无法添加数据");
            return;
        }
        arr[rear] = val;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空， 不能取数据");
        }
        // 先把front对应的值保存到一个临时变量
        // 将front后移
        // 将临时保存的变量返回
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

    /**
     * 显示数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~~~~");
            return;
        }
        // 从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前队列的有效数据的个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头数据，注意：不是取数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~~~~");
        }
        return arr[front];
    }
}




