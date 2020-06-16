package com.fan.tujiedesignpattern.chap01;

/**
 * @Description :
 * @Author : fanshulin
 * @Date : 2020/6/2
 */
public interface Iterator {
    /**
     * 是否还有没有遍历的元素
     *
     * @return 还有未迭代的元素：true | 没有未迭代的元素：false
     */
    boolean hasNext();

    /**
     * next
     *
     * @return 下一个迭代元素
     */
    Object next();
}
