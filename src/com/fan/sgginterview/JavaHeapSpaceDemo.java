package com.fan.sgginterview;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "seu";

        while (true) {
            // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            //	at java.util.Arrays.copyOf(Arrays.java:3332)
            //	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
            //	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
            //	at java.lang.StringBuilder.append(StringBuilder.java:208)
            str += str + new Random().nextInt(11111111) + new Random().nextInt(22222222);
            str.intern();
        }

    }
}