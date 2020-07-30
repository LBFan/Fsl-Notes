package com.fan.designpattern.create.singleton;

/**
 * @Description : 枚举实现单例
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public enum Singleton02 {
    /**
     * instance
     */
    INSTANCE;

    /*// 定义单例模式中需要完成的代码逻辑
    public interface MySingleton {
        void doSomething();
    }

    public enum Singleton implements MySingleton {
        INSTANCE {
            @Override
            public void doSomething() {
                System.out.println("complete singleton");
            }
        };

        public static MySingleton getInstance() {
            return Singleton.INSTANCE;
        }
    }*/

    /*public enum Singleton {
        INSTANCE;
        // 这里隐藏了一个空的私有构造方法
        private Singleton () {}
    }*/
}
