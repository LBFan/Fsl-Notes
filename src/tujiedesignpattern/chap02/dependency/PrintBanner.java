package tujiedesignpattern.chap02.dependency;

import tujiedesignpattern.chap02.Banner;
import tujiedesignpattern.chap02.Print;

/**
 * @author : PF_23
 * @Description : 对象适配器模式
 * @date : 2020/06/03.
 */

public class PrintBanner implements Print {
    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}

