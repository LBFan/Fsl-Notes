package com.fan.designpattern.create.builder.builders;

import com.fan.designpattern.create.builder.cars.Type;
import com.fan.designpattern.create.builder.components.Engine;
import com.fan.designpattern.create.builder.components.GPSNavigator;
import com.fan.designpattern.create.builder.components.Transmission;
import com.fan.designpattern.create.builder.components.TripComputer;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public interface Builder {
    void setType(Type type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}