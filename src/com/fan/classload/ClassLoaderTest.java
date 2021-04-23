package com.fan.classload;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author : PF_23
 * @Description : 类加载器了解
 * @date : 2021/4/15 22:27.
 */

public class ClassLoaderTest {
    @Test
    public void test1() throws Exception {
        Properties pro = new Properties();
        ////读取配置文件方式一：类加载器 ：默认在当前module下
        //FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        //pro.load(fileInputStream);

        // 读取配置文件方式二：类加载器 ：默认在当前src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 加载当前src下的配置文件
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");

        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        System.out.println("user = " + user + ", password = " + password);

    }
}

