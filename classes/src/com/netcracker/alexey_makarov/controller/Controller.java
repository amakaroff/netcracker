package com.netcracker.alexey_makarov.controller;

import com.netcracker.alexey_makarov.model.Car;
import com.netcracker.alexey_makarov.model.impl.LadaCar;
import com.netcracker.alexey_makarov.model.impl.MitsubishiCar;
import com.netcracker.alexey_makarov.model.impl.VolkswagenCar;
import com.netcracker.alexey_makarov.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 15.10.2016.
 */
public class Controller {

    View view;
    List<Car> garage;

    public Controller(View view) {
        this.view = view;
        garage = new ArrayList<Car>();
    }

    public void addCar() {
        Car car;
        view.print("Select car");
        view.print("1. Lada\n2. Mitsubisi\n3. Vokswagen");
        int option = Integer.parseInt(view.read());

        view.print("Enter name");
        String name = view.read();

        view.print("Enter cost");
        int cost = Integer.parseInt(view.read());

        if (option == 1) {
            car = new LadaCar(name, cost);
        } else if (option == 2) {
            car = new MitsubishiCar(name, cost);
        } else if (option == 3) {
            car = new VolkswagenCar(name, cost);
        } else {
            car = null;
        }
        garage.add(car);
    }

    public void allGo() {
        for (Car car : garage) {
            if (car != null && car.isCanGo()) {
                car.go();
                view.print("car " + car.toString() + " is go");
            } else {
                view.print("car is can't go");
            }
        }
    }
}
