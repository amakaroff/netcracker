package com.netcracker.alexey_makarov.model;

import com.netcracker.alexey_makarov.contract.Going;

/**
 * Created by Алексей on 15.10.2016.
 */
public abstract class Car implements Going {

    protected String name;
    protected int cost;
    protected int mileage;

    public abstract boolean isCanGo();

    public Car() {
    }

    public Car(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name + " " + cost + " " + mileage;
    }
}
