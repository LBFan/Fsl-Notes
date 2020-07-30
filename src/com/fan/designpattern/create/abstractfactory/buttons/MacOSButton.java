package com.fan.designpattern.create.abstractfactory.buttons;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("you have created macos button");
    }
}
