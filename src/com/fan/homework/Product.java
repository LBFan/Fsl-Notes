package com.fan.homework;

import static com.fan.homework.Client.*;

/**
 * @author : PF_23
 * @Description : 模拟随机用户购买随机商品
 * @date : 2021/7/24 21:13.
 */

public class Product implements Runnable {
    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品描述
     */
    private String desc;

    /**
     * 商品数量
     */
    private Long count;

    /**
     * 购买商品所需积分
     */
    private Integer price;

    public Product(Long id, String desc, Long count, Integer price) {
        this.id = id;
        this.desc = desc;
        this.count = count;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

    @Override
    public void run() {
        if (customerList.isEmpty()) {
            System.out.println("当前用户不存在!!!");
            return;
        }
        if (productList.isEmpty()) {
            System.out.println("所有商品都已经卖光了！！！");
            return;
        }
        transaction();
    }

    /**
     * 随机用户购买随机商品,当前商品加锁
     */
    private synchronized void transaction() {
        // 锁定用户集合对象
        synchronized (customerList) {
            if (customerList.isEmpty()) {
                System.out.println("当前用户不存在!!!");
                return;
            }
            int buyerIndex = (int) (Math.random() * customerList.size());
            Customer customer = customerList.get(buyerIndex);
            // 锁定商品集合对象
            synchronized (productList) {
                if (productList.isEmpty()) {
                    System.out.println("所有商品都已经卖光了！！！");
                    return;
                }
                if (!productList.contains(this)) {
                    //System.out.println("不存在当前商品");
                    return;
                }
                if (conditions(customer, this)) {
                    return;
                }

                getResultMap(customer, this);
            }
        }
    }

    /**
     * 执行购买过程
     * 1. 用户减购买积分money
     * 2. 商品减数量count
     * 3. 购买结果新增购买记录（有则购买数量+1，无则新增购买记录，数量为1）
     */
    private void getResultMap(Customer customer, Product product) {
        customer.setMoney(customer.getMoney() - product.getPrice());
        product.setCount(product.getCount() - 1);
        //System.out.println("用户:" + customer.getId() + "购买商品：" + this.getId());
        result.put(product.getId(), result.getOrDefault(product.getId(), 0L) + 1);
    }

    private boolean conditions(Customer customer, Product product) {
        if (customer.getMoney() <= 0) {
            // 该用户已经使用完积分，提示并且移除
            System.out.println("用户" + customer.getId() + "没有可以使用的积分了！！！");
            customerList.remove(customer);
            return true;
        }
        if (product.getCount() <= 0) {
            // 该商品无货，提示并且移除
            System.out.println("商品" + product.getId() + "已经卖光了！！！");
            productList.remove(product);
            return true;
        }

        if (customer.getMoney() < product.getPrice()) {
            // 该用户购买当前商品的积分不够，提示重新选择其他商品进行购买
            System.out.println("用户" + customer.getId() + "购买当前商品" + customer.getId() + "所需的积分不够，请重新选择商品进行购买！！！");
            return true;
        }
        return false;
    }
}

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2021/7/24 21:15.
 */
class Customer {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户积分
     */
    private Long money;

    public Customer(Long id, Long money) {
        this.id = id;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}

