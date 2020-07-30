package com.fan.designpattern.create.abstractfactory.app;

import com.fan.designpattern.create.abstractfactory.buttons.Button;
import com.fan.designpattern.create.abstractfactory.checkbox.Checkbox;
import com.fan.designpattern.create.abstractfactory.factories.GUIFactory;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
