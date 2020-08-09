package com.fan.bit.proandcon;

import java.util.concurrent.BlockingQueue;

/**
 * @Description : 生产和消费的对象
 * @Author : shulin.fan
 * @Date : 2020/8/9
 */
public class Apple {

    private int id;

    public Apple(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Apple [id=" + id + "]";
    }
}
