package com.fan.wangzheng_shujujiegouyusuanfazhimei;

import java.util.Stack;

/**
 * @author : PF_23
 * @Description : 实现浏览器的前进后退功能
 * @date : 2021/4/20 20:40.
 */

public class BrowserFrontAndBack {
    private static Stack<String> front = new Stack<>();
    private static Stack<String> back = new Stack<>();

    /**
     * 前进
     *
     * @return 前进后当前页链接
     */
    public static String back2front() {
        if (back.isEmpty()) {
            throw new RuntimeException("当前页已经是最后一页，无法前进");
        }

        front.push(back.pop());
        return front.peek();
    }

    /**
     * 后退
     *
     * @return 后退后当前页链接
     */
    public static String front2back() {
        if (front.isEmpty()) {
            throw new RuntimeException("当前页已经是第一页，无法后退");
        }
        back.push(front.pop());
        if (front.isEmpty()) {
            return "";
        }
        return front.peek();
    }

    /**
     * 进入新链接
     *
     * @param url 新页面链接
     * @return 当前页链接
     */
    public static String newUrl(String url) {
        front.push(url);
        while (!back.isEmpty()) {
            back.pop();
        }
        return front.peek();
    }

    public static void main(String[] args) {
        front.push("a");
        front.push("b");
        front.push("c");
        String back1 = front2back();
        System.out.println("back1:"+back1);
        String newUrl = newUrl("d");
        System.out.println("newUrl:"+newUrl);
        System.out.println(back.isEmpty());
        String back2 = front2back();
        System.out.println("back2:"+back2);
        String back3 = front2back();
        System.out.println("back3:"+back3);
        String back4 = front2back();
        System.out.println("back4:"+back4);
        String front1 = back2front();
        System.out.println("front1:" + front1);
        String back5 = front2back();
        System.out.println("back5:"+back5);
        //String s = back2front();
        //System.out.println(s);

    }
}

