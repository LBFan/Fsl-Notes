package tujiedesignpattern.chap02.extend;

import tujiedesignpattern.chap02.Banner;
import tujiedesignpattern.chap02.Print;

/**
 * @author : PF_23
 * @Description : 类适配器模式
 * @date : 2020/06/03.
 */

public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}

