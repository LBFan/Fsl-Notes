package com.fan.proxy;

/**
 * @author :  PF_23
 * @Description : 简单静态代理
 * @date : 2019/12/02.
 */

public class SimpleStaticProxyDemo {
    static interface IService {
        void sayHello();
    }

    static class RealService implements IService {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class TraceProxy implements IService {
        private IService realService;

        public TraceProxy(IService realService) {
            this.realService = realService;
        }

        @Override
        public void sayHello() {
            System.out.println("entering say hello");
            this.realService.sayHello();
            System.out.println("leaving say hello");
        }
    }

    public static void main(String[] args) {
        IService realService = new RealService();
        IService traceProxy = new TraceProxy(realService);
        traceProxy.sayHello();
    }
}

