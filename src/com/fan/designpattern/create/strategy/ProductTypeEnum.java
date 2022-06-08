package com.fan.designpattern.create.strategy;

/**
 * @author : PF_23
 * @Description : 商品折扣类型枚举类
 * @date : 2021/8/4 23:15.
 */

public enum ProductTypeEnum {
    NO_DIS(0, "没有折扣"),DIS_10(1, "九折商品"),DIS_20(2, "八折商品"),BUY_2_GIVE_1(3, "买二赠一商品");

    private int code;

    private String msg;

    ProductTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}