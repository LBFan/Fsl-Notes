package lanqiaobei.recursion;

/**
 * @author :  PF_23
 * @Description : 对n进行加法划分
 * 6
 * 5 + 1
 * 4 + 2， 4 + 1 + 1
 * 3 + 3， 3 + 2 + 1， 3 + 1 + 1 + 1
 * 2 + 2 + 2， 2 + 2 + 1+ 1， 2 + 1 +1 + 1+ 1
 * 1 + 1 + 1 + 1 + 1 + 1
 * @date : 2020/04/09.
 */

public class One {

    /**
     * @param n
     * @param a 缓冲
     * @param k 当前的位置
     */
    private static void f(int n, int[] a, int k) {
        if (n <= 0) {
            for (int i = 0; i < k; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = n; i > 0; i--) {
            if (k > 0 && i > a[k - 1]) {
                continue;
            }
            a[k] = i;
            f(n - i, a, k + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        f(6, a, 0);
    }
}

