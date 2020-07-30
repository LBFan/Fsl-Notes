package com.fan.designpattern.create.abstractfactory.factories;


import com.fan.designpattern.create.abstractfactory.buttons.Button;
import com.fan.designpattern.create.abstractfactory.checkbox.Checkbox;


/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
