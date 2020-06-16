package com.fan.focusonoffer;

/**
 * @author :  PF_23
 * @Description : 求 1+2+3+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C。
 * <p>
 * 思路：
 * 本题的递归返回条件为 n <= 0，取非后就是 n > 0；
 * 递归的主体部分为 sum += Sum_Solution(n - 1)，转换为条件语句后就是 (sum += Sum_Solution(n - 1)) > 0。
 * TODO
 * @date : 2019/12/31.
 */

public class Num64 {
    public int Sum_Solution(int n) {
        int sum = 0;
        boolean b = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}

