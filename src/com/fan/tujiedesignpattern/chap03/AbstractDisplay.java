package com.fan.tujiedesignpattern.chap03;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/06/04.
 */

public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void dispaly() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}

