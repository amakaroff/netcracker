package com.netcracker.edu.ssu.homework003;

import com.netcracker.edu.ssu.homework003.calculator.api.Calculator;
import com.netcracker.edu.ssu.homework003.calculator.impl.StringCalculator;

public class Main {

    public static void main(String[] args) {
        String line = "((23+77)*(4-(4+23))+1)";
        Calculator calculator = new StringCalculator();
        System.out.println(String.format("%s = %s", line, calculator.calculate(line)));
    }
}
