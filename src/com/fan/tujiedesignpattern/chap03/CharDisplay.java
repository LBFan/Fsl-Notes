package com.fan.tujiedesignpattern.chap03;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/06/04.
 */

public class CharDisplay extends AbstractDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}

