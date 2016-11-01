package com.netcracker.edu.ssu.homework003.functional.impl;

import com.netcracker.edu.ssu.homework003.functional.api.CheckerAndConsider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алексей on 01.11.2016.
 */
public class Functional implements CheckerAndConsider {
    @Override
    public int count(int firstNumber, int secondNumber, char operator) {
        switch (operator) {
            case ('*'):
                return firstNumber * secondNumber;
            case ('/'):
                return firstNumber / secondNumber;
            case ('%'):
                return firstNumber % secondNumber;
            case ('+'):
                return firstNumber + secondNumber;
            case ('-'):
                return firstNumber - secondNumber;
        }
        return 0; //stub
    }

    @Override
    public boolean isNumber(String expression) {
        Pattern pattern = Pattern.compile("[+-]?[\\d]+");
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }

    @Override
    public boolean isEasyOperator(char sign) {
        return sign == '+' || sign == '-';
    }

    @Override
    public boolean isHardOperator(char sign) {
        return sign == '*' || sign == '/' || sign == '%';
    }
}
