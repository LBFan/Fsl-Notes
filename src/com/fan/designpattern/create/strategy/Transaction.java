package com.fan.designpattern.create.strategy;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2021/8/4 23:33.
 */

public class Transaction {

    /**本次购物消费总金额*/
    private Double totalCount;

    /**本次购物消费获得的总积分*/
    private int totalPoint;

    public Double getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Double totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }
}

