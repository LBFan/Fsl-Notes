package com.fan.designpattern.create.abstractfactory.factories;

import com.fan.designpattern.create.abstractfactory.buttons.Button;
import com.fan.designpattern.create.abstractfactory.buttons.MacOSButton;
import com.fan.designpattern.create.abstractfactory.checkbox.Checkbox;
import com.fan.designpattern.create.abstractfactory.checkbox.MacOSCheckbox;


/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
