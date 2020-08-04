package com.fan.exam.jianzhioffer;

import java.io.File;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/8/5
 */
public class Dir {
    public static void main(String[] args) {
        File file = new File("D:\\");
        printFile(file);
    }

    private static void printFile(File file) {
        if (file.exists()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    System.out.println("Dir : " + f.getName());
                    printFile(f);
                } else {
                    System.out.println("File : " + f.getName());
                }
            }
        }
    }
}
