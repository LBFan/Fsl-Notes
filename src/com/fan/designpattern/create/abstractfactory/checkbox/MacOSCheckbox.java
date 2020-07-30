package com.fan.designpattern.create.abstractfactory.checkbox;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
