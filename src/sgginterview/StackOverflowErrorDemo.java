package sgginterview;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/04/11.
 */

public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }


    private static void stackOverflowError() {
        stackOverflowError();
    }
}
///out:
//Exception in thread "main" java.lang.StackOverflowError
//	at sgginterview.StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:15)
//	at sgginterview.StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:15)
//	at sgginterview.StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:15)
//	at sgginterview.StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:15)
//	at sgginterview.StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:15)

