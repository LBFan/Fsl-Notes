package com.fan.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : PF_23
 * @Description : 测试客户端
 * @date : 2021/7/25 10:09.
 */

public class Client {

    /**
     * 商品信息集合
     */
    public static final List<Product> productList = new ArrayList<>();
    /**
     * 用户信息集合
     */
    public static final List<Customer> customerList = new ArrayList<>();
    /**
     * 最终用户购买结果信息 key:商品id，value：商品的购买数量
     */
    public static final Map<Long, Long> result = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Product product = new Product((long) (i + 1), "第" + i + "个商品", 20000L, 1);
            productList.add(product);
        }
        for (int i = 0; i < 50; i++) {
            Customer customer = new Customer((long) (i + 1), 6000L);
            customerList.add(customer);
        }
        System.out.println("初始商品信息");
        productList.forEach(System.out::println);

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100101; i++) {
            if (productList.size() == 0) {
                break;
            }
            service.execute(productList.get((int) (Math.random() * productList.size())));
        }
        service.shutdown();

        // 打印最终购买结果
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long transCount = 0L;
        for (Long value : result.values()) {
            transCount += value;
        }
        System.out.println("成交商品总量:" + transCount);
        // 统计商品剩余数量
        Long leftCount = 0L;
        for (Product product : productList) {
            leftCount += product.getCount();
        }
        System.out.println("剩余商品总量:" + leftCount);
        // 打印每类商品的购买数量
        for (Long aLong : result.keySet()) {
            System.out.println("商品" + aLong + "交易量：" + result.get(aLong));
        }
    }
}