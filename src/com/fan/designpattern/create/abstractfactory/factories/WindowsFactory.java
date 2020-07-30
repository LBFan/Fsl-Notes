package com.fan.designpattern.create.abstractfactory.factories;

import com.fan.designpattern.create.abstractfactory.buttons.Button;
import com.fan.designpattern.create.abstractfactory.buttons.WindowsButton;
import com.fan.designpattern.create.abstractfactory.checkbox.Checkbox;
import com.fan.designpattern.create.abstractfactory.checkbox.WindowsCheckbox;


/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
