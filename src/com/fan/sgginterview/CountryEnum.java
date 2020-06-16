package com.fan.sgginterview;

/**
 * @author :  PF_23
 * @Description : 枚举国家
 * @date : 2020/04/10.
 */

public enum CountryEnum {

    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");


    private Integer retCode;

    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum element : countryEnums) {
            if (index == element.getRetCode()) {
                return element;
            }
        }
        return null;
    }
}