import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author :  PF_23
 * @Description : java中只有值传递
 * @date : 2020/04/02.
 */

public class ParamTest {

    public static void main(String[] args) {
        ParamTest pt = new ParamTest();

        int i = 10;
        pt.pass(i);
        System.out.println("print in main , i is " + i);
    }
    ///print in pass , j is 20
    //print in main , i is 10


    public void pass(int j) {
        j = 20;
        System.out.println("print in pass , j is " + j);

    }
}

