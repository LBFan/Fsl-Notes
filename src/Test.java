import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/02/18.
 */

public class Test {
    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";

    private static char nextChar(Random rnd) {
        switch (rnd.nextInt(4)) {
            case 0:
                return (char) ('a' + rnd.nextInt(26));
            case 1:
                return (char) ('A' + rnd.nextInt(26));
            case 2:
                return (char) ('0' + rnd.nextInt(10));
            default:
                return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
        }
    }

    private static int nextIndex(char[] chars, Random rnd) {
        int index = rnd.nextInt(chars.length);
        while (chars[index] != 0) {
            index = rnd.nextInt(chars.length);
        }
        return index;
    }

    private static char nextSpecialChar(Random rnd) {
        return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
    }

    private static char nextUpperlLetter(Random rnd) {
        return (char) ('A' + rnd.nextInt(26));
    }

    private static char nextLowerLetter(Random rnd) {
        return (char) ('a' + rnd.nextInt(26));
    }

    private static char nextNumLetter(Random rnd) {
        return (char) ('0' + rnd.nextInt(10));
    }

    public static String randomPassword() {
        char[] chars = new char[8];
        Random rnd = new Random();
        chars[nextIndex(chars, rnd)] = nextSpecialChar(rnd);
        chars[nextIndex(chars, rnd)] = nextUpperlLetter(rnd);
        chars[nextIndex(chars, rnd)] = nextLowerLetter(rnd);
        chars[nextIndex(chars, rnd)] = nextNumLetter(rnd);
        for (int i = 0; i < 8; i++) {
            if (chars[i] == 0) {
                chars[i] = nextChar(rnd);
            }
        }
        return new String(chars);
    }

    private static int[] ranNum(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i;
        }
        Random rad = new Random();
        for (int i = arr.length; i > 1; i--) {
            swap(arr, i - 1, rad.nextInt(i));
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

//    public static void main(String[] args) {
//        String randomPassword = randomPassword();
//        System.out.println(randomPassword);
//        int[] num = ranNum(new int[10]);
//        System.out.println(Arrays.toString(num));
//        int a;
//        a = 2;
//        System.out.println(a);

//        String s = "abc";
//        s.concat("abc");
//        System.out.println(s);
//
//        String c = "123";
//        String b = "123";
//        System.out.println(c == b);
//
//        String tryFinal = tryFinal();
//        System.out.println(tryFinal);
//
//        String a = "";
//        for (int i = 0; i < 100000000; i++) {
//            a += "fbhueiwhqiojhfeiowajhfiopehjig";
//            System.out.println(i);
//        }
//    }


    private static String tryFinal() {
        try {
            return "a";
        } finally {
            return "b";
        }
    }

}

