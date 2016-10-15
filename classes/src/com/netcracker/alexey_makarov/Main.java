package com.netcracker.alexey_makarov;

import com.netcracker.alexey_makarov.controller.Controller;
import com.netcracker.alexey_makarov.view.impl.ConsoleView;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new ConsoleView());

        controller.addCar();
        controller.addCar();
        controller.addCar();

        System.out.println();
        controller.allGo();
        System.out.println();
        controller.allGo();
        System.out.println();
        controller.allGo();
    }
}
