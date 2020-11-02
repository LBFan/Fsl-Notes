package com.fan.toutiao;

import java.math.BigInteger;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/09/20.
 */

public class Main02 {
    public static void main(String[] args) {
        BigInteger pow = BigInteger.valueOf(2).pow(1000000000);
//        System.out.println(pow.toString());
        System.out.println(pow.intValue());
    }
}

