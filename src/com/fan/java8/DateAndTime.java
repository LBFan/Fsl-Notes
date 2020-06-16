package com.fan.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/02.
 */

public class DateAndTime {
    public static void main(String[] args) {
        // Instant􏰆􏰿􏰂􏰚􏲍􏱦􏰑􏰈􏱜􏰂􏰚表示时刻，获取当前时刻
        Instant now = Instant.now();
        Instant anotherNow = now.ofEpochMilli(System.currentTimeMillis());
        Instant dateToNow = now.ofEpochMilli(new Date().getTime());
        System.out.println(now);
        System.out.println(anotherNow);
        System.out.println(dateToNow);

        // LocalDateTime与时区无关的日期和时间
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println(localDateTimeNow);
        LocalDateTime ldt = LocalDateTime.of(2019, 12, 2, 12, 45, 5, 543000000);
        System.out.println(ldt);
        System.out.println("====================");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt2 = LocalDateTime.of(2019,8,18,14,20,45);
        System.out.println(formatter.format(ldt2));
    }
}

