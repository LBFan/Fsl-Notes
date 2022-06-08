package com.fan.designpattern.create.strategy.strategy;

import com.fan.designpattern.create.strategy.Product;
import com.fan.designpattern.create.strategy.Transaction;

import java.util.List;

/**
 * @author : PF_23
 * @Description : 打折策略接口
 * @date : 2021/8/4 23:09.
 */

public interface DiscountCalculation {

    /**
     * 计算商品优惠价格
     */
    Transaction calculationDiscount(List<Product> productList);
}