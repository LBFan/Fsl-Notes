package com.fan.execPy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : PF_23
 * @Description : Java调用Python代码
 * @date : 2020/11/23.
 */

public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("start");
            Process pr = Runtime.getRuntime().exec("/usr/local/bin/python3.6 /Users/HuXin/Documents/workspace/Fsl-Notes/src/com/fan/execPy/hello.py");

            BufferedReader in = new BufferedReader(new
                    InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

