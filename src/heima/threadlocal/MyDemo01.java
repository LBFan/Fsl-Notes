package heima.threadlocal;

/**
 * @author : PF_23
 * @Description : 线程隔离：
 * 每个线程中的变量都是独立的
 * ThreadLocal基本使用：
 *  1. set() : 将变量绑定到当前线程中
 *  2. get() : 获取当前线程绑定的变量
 * @date : 2020/05/26.
 */

public class MyDemo01 {

    ThreadLocal<String> t1 = new ThreadLocal<>();
    private String content;

    public String getContent() {
        return t1.get();
    }

    public void setContent(String content) {
        t1.set(content);
    }

    public static void main(String[] args) {
        MyDemo01 demo = new MyDemo01();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                demo.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("------------------");
                System.out.println(Thread.currentThread().getName() + "---->" + demo.getContent());
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}

