package com.fan.tujiedesignpattern.chap02.extend;

import com.fan.tujiedesignpattern.chap02.Print;

/**
 * @author : PF_23
 * @Description : 测试类
 * @date : 2020/06/03.
 */

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
        /// out:
        //(Hello)
        //*Hello*
    }
}

