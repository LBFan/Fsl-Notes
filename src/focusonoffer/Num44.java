package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 数字序列中的某一位数字
 * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 * TODO
 * @date : 2019/12/30.
 */

public class Num44 {

    public int findNthDigit(int n) {
        // if (n < 0) {
        //     return -1;
        // }
        // // 1 表示个位，2 表示 十位...
        // int place = 1;
        // while (true) {
        //     int amount = getAmountOfPlace(place);
        //     int totalAmount = amount * place;
        //     if (n < totalAmount) {
        //         return getDigitAtIndex(n, place);
        //     }
        //     n -= totalAmount;
        //     place++;
        // }


        //i位数的个数
        //它是j位数当中的第n/j个中的第n%j位（从左往右数）
        //j位数的第0个数
        //找到了所在的数
        //从左往右找到n%j位
        // TODO
        return 0;
    }

    /**
     * 在 place 位数组成的字符串中，第 index 个数
     *
     * @param index
     * @param place
     * @return
     */
    private int getDigitAtIndex(int index, int place) {
        // TODO
        return 0;
    }

    /**
     * place 位数的起始数字
     * 0, 10, 100, ...
     *
     * @param place
     * @return
     */
    private int getBeginNumberOfPlace(int place) {
// TODO
        return 0;
    }

    /**
     * place 位数的数字组成的字符串长度
     * 10, 90, 900, ...
     *
     * @param place
     * @return
     */
    private int getAmountOfPlace(int place) {
// TODO
        return 0;
    }

    public static void main(String[] args) {
        Num44 num44 = new Num44();
        int n = 365;
        int digitAtIndex1 = num44.findNthDigit(n);
        System.out.println(digitAtIndex1);
        System.out.println("-----------------------");
        for (int i = 1; i <= n; i++) {
            int digitAtIndex = num44.findNthDigit(i);
            System.out.println(digitAtIndex);
        }
    }
}

