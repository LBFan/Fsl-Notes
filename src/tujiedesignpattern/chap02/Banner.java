package tujiedesignpattern.chap02;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/06/03.
 */

public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}

