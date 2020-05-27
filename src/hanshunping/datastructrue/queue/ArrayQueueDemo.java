package hanshunping.datastructrue.queue;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 数组模拟队列
 * 只能使用一次
 * @date : 2020/03/17.
 */

public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 测试
        // 创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
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
                        System.out.printf("取出的数据是%d", res);
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

/**
 * 使用数组模拟队列 -编写一个ArrayQueue类
 */
class ArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队列头 ： 指向队列头部， 分析出front是指向队列头的前一个位置
     */
    private int front;

    /**
     * 队列尾 ： 指向队列尾的数据
     */
    private int rear;

    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        // 注意：front是头元素的前一个节点，所以头元素是arr[front + 1]
        this.front = -1;
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int val) {
        if (isFull()) {
            System.out.println("队列满，无法添加数据");
            return;
        }
//        rear++;
//        arr[rear] = val;
        arr[++rear] = val;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空， 不能取数据");
        }
//        front++;
//        return arr[front];
        return arr[++front];
    }

    /**
     * 显示数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~~~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据，注意：不是取数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~~~~");
        }
        // 注意：这里没有取出元素，只是查看头元素，所以不能移动front
        return arr[front + 1];
    }
}

