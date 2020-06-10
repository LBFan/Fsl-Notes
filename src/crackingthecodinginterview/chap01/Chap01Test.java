package crackingthecodinginterview.chap01;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author : PF_23
 * @Description :
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
        String result= Num03.replaceSpaces(s);
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
}