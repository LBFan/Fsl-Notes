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
}