package com.fan.designpattern.create.abstractfactory;

import com.fan.designpattern.create.abstractfactory.app.Application;
import com.fan.designpattern.create.abstractfactory.factories.GUIFactory;
import com.fan.designpattern.create.abstractfactory.factories.MacOSFactory;
import com.fan.designpattern.create.abstractfactory.factories.WindowsFactory;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public class Demo {
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
