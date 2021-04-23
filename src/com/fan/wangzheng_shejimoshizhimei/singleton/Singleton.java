package com.fan.wangzheng_shejimoshizhimei.singleton;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author : PF_23
 * @Description : 单例模式的实际应用
 * @date : 2021/4/10 23:55.
 */

public class Singleton {
    public static String generate() {
        String id = "";
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            System.out.println(hostname);
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(hostAddress);
            String[] tokens = hostname.split("\\.");
            if (tokens.length > 0) {
                hostname = tokens[tokens.length - 1];
            }
            System.out.println(hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void main(String[] args) {
        generate();
    }
}

