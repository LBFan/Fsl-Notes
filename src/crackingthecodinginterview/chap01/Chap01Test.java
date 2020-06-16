package crackingthecodinginterview.chap01;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author : PF_23
 * @Description : chap01 test
 * @date : 2020/06/09.
 */
public class Chap01Test {

    @Test
    public void testNum01() {
        String str = "qwertyxq";
        boolean uniqueChars = Num01.isUniqueChars(str);
        Assert.assertFalse(uniqueChars);
    }

    @Test
    public void testNum02() {
        String s = "ertyuio", t = "reytiou";
        boolean permutation = Num02.permutation(s, t);
        Assert.assertTrue(permutation);
        String r = "fghj";
        Assert.assertFalse(Num02.permutation2(s, r));

    }

    @Test
    public void testNum03() {
        String s = "er tyu io";
        String result = Num03.replaceSpaces(s);
        Assert.assertEquals("er%20tyu%20io", result);
    }

    @Test
    public void testNum04() {
        String s = "tactact";
        boolean palindromePermutation1 = Num04.palindromePermutation1(s);
        Assert.assertTrue(palindromePermutation1);
    }

    @Test
    public void testNum05() {
        String first = "ple", second = "pale";
        boolean b = Num05.oneEditWay(first, second);
        Assert.assertTrue(b);
    }

    @Test
    public void testNum06() {
        String s = "aaabbbbbcc";
        String t = "abc";
        String compress = Num06.compress(s);
        Assert.assertEquals("a3b5c2", compress);
        String compress1 = Num06.compress(t);
        Assert.assertEquals("abc", compress1);
    }

    @Test
    public void testNum07() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        boolean rotate = Num07.rotate(matrix);
        Assert.assertTrue(rotate);
    }

    @Test
    public void testNum08() {
        int[][] matrix = {{1, 1, 1, 0, 1, 1}, {0, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 0}};
        Num08.zeroMatrix(matrix);
        int[][] result = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}};
        Assert.assertNotSame(result, matrix);
    }

    @Test
    public void testNum09() {
        String s1 = "waterbottle", s2 = "erbottlewat";
        boolean rotate = Num09.isRotate(s1, s2);
        Assert.assertTrue(rotate);
    }
}