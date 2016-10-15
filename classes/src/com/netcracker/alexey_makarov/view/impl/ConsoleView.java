package com.netcracker.alexey_makarov.view.impl;

import com.netcracker.alexey_makarov.view.View;

import java.util.Scanner;

/**
 * Created by Алексей on 15.10.2016.
 */
public class ConsoleView implements View {

    Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void print(String data) {
        System.out.println(data);
    }

    @Override
    public String read() {
        return this.scanner.nextLine();
    }
}
