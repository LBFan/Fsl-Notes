package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 表示数值的字符串
 * 使用正则表达式进行匹配。
 * <p>
 * 核心: 有效数字的模式只有两种:
 * 1)A[.[B]][e|EC]  比如: +100   -67.0  29.    3.14E5
 * 2).B[e|EC]       比如: .3     .4E6
 * 其中,A、C是整数，B是正整数; [e|EC]表示[eC]或者[EC]
 * 原则: 有A的话,有没有B都可以; 没有A的话, 必须有B
 * @date : 2019/12/23.
 */

public class Num20 {
    /**
     * 扫描字符串时的索引
     */
    int i = 0;

    public boolean isNumber(String s) {
        //input check

        //去掉首尾的空字符
        //判断是否有A; 同时将B,C初始化为false
        //判断是否有B; 使用索引时要确保索引不越界

        //i当前指向'.', 所以需要i++
        //判断是否有C
        //如果存在e|E, 但是没有C, 说明不是数字
        //here, 说明C是合格的, 只需判断A和B的情况
        //i必须扫描完整个字符串 && (有A的话,有没有B都可以; 没有A的话, 必须有B)
        // TODO
        return false;

    }

    //扫描整数
    private boolean scanInteger(String s) {
        //判断是否有'+'或者'-'
        //扫描正整数
        // TODO
        return false;
    }

    //扫描正整数
    private boolean scanUnsignedInteger(String s) {
        //起始索引
        //i>start说明扫描到了数字;
        //i<=start说明没有扫描到数字, 此种情况说明要么start越界, 要么s.charAt(start)不是数字
        // TODO
        return false;
    }
}

