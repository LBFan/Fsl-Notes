package com.fan.jvm.cha02;

/**
 * @author :  PF_23
 * @Description : 虚拟机桟和native方法桟OOM测试
 * @date : 2020/04/07.
 */

public class Four {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        Four oom = new Four();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length :" + oom.stackLength);
            throw e;
        }
    }
}

