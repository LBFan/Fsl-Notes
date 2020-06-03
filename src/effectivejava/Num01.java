package effectivejava;

import java.time.Instant;

/**
 * @Description :
 * @Author : fanshulin
 * @Date : 2020/6/2
 */
public class Num01 {
    public static void main(String[] args) {
        Instant start = Instant.now();
        long sum = sum();
        Instant end = Instant.now();
        // Long sum :耗时：1591094667026
        System.out.println("耗时：" + end.toEpochMilli());
    }

    private static final long sum() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
