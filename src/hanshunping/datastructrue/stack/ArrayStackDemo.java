package hanshunping.datastructrue.stack;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 数组模拟桟的实现
 * @date : 2020/03/17.
 */

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下 ArrayStack 是否正确 //先创建一个 ArrayStack 对象->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        //控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }
}


/**
 * 定义一个ArrayStack类 表示桟
 */
class ArrayStack {
    private int maxSize;

    private int[] stack;

    private int top = -1;


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断是否桟满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断是否桟空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("桟满");
            return;
        }
//        top++;
//        stack[top] = val;
        stack[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("桟为空");
        }
        return stack[top--];
    }

    /**
     * 遍历时需要从栈顶开始显示
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("桟空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}

