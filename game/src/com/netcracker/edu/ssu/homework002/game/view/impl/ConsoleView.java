package com.netcracker.edu.ssu.homework002.game.view.impl;


import com.netcracker.edu.ssu.homework002.game.view.api.View;

import java.util.Scanner;

/**
 * Created by Alexey on 21.10.2016.
 */

public class ConsoleView implements View {

    private static final ConsoleView INSTANCE = new ConsoleView();
    private static final Scanner scanner = new Scanner(System.in);

    private ConsoleView() {
    }

    public static ConsoleView getInstance() {
        return INSTANCE;
    }

    @Override
    public void print(String data, boolean toNextLine) {
        if (toNextLine) {
            System.out.println(data);
        } else {
            System.out.print(data);
        }
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
