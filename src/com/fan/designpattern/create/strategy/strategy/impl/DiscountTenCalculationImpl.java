package com.fan.designpattern.create.strategy.strategy.impl;

import com.fan.designpattern.create.strategy.Product;
import com.fan.designpattern.create.strategy.Transaction;
import com.fan.designpattern.create.strategy.strategy.DiscountCalculation;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : PF_23
 * @Description : 九折商品计算策略实现类
 * @date : 2021/8/4 23:21.
 */

public class DiscountTenCalculationImpl implements DiscountCalculation {
    @Override
    public Transaction calculationDiscount(List<Product> productList) {
        Transaction transaction = new Transaction();

        // 计算当前商品购买的总价和获得的积分
        Double totalPrice = productList.stream().map(Product::getPrice).reduce(0d, (a, b) -> new BigDecimal(Double.toString(a)).add(new BigDecimal(Double.toString(b))).doubleValue());

        BigDecimal decimal = new BigDecimal(Double.toString(totalPrice));
        int currentPoint = decimal.divide(BigDecimal.valueOf(5)).intValue();
        transaction.setTotalPoint(currentPoint);
        double currentPrice = decimal.multiply(new BigDecimal("0.9")).doubleValue();
        transaction.setTotalCount(currentPrice);
        return transaction;
    }
}

