package com.fan.didi;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @Description :幂运算
 * @Author : shulin.fan
 * @Date : 2020/8/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigDecimal r = sc.nextBigDecimal();
            int n = sc.nextInt();
            BigDecimal res = r.pow(n);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);
            nf.setMaximumFractionDigits(100);
            System.out.println(nf.format(res));
        }
        sc.close();
    }
}
