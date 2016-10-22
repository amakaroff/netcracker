package com.netcracker.alexey_makarov.model.impl;

import com.netcracker.alexey_makarov.model.Car;

/**
 * Created by Алексей on 15.10.2016.
 */
public class MitsubishiCar extends Car {

    private static final int MAX_RUN = 30000;

    public MitsubishiCar() {
    }

    public MitsubishiCar(String name, int cost) {
        super(name, cost);
        this.mileage = 0;
    }

    @Override
    public boolean isCanGo() {
        return mileage < MAX_RUN;
    }

    @Override
    public void go() {
        if (isCanGo()) {
            this.mileage += 2000;
        }
    }
}
