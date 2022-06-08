package com.fan.designpattern.create.strategy;

/**
 * @author : PF_23
 * @Description : 商品
 * @date : 2021/8/4 23:10.
 */

public class Product {

    /**
     * 商品价格
     */
    private double price;

    /**
     * 商品类型
     */
    private ProductTypeEnum typeEnum;

    public Product(double price, ProductTypeEnum typeEnum) {
        this.price = price;
        this.typeEnum = typeEnum;
    }

    public double getPrice() {
        return price;
    }

    public ProductTypeEnum getTypeEnum() {
        return typeEnum;
    }
}

