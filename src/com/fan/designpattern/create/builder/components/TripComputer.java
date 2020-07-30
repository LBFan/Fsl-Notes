package com.fan.designpattern.create.builder.components;

import com.fan.designpattern.create.builder.cars.Car;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}
