package com.netcracker.edu.ssu.homework003.calculator.impl;

import com.netcracker.edu.ssu.homework003.functional.api.CheckerAndConsider;
import com.netcracker.edu.ssu.homework003.functional.impl.Functional;
import com.netcracker.edu.ssu.homework003.parser.api.Parser;
import com.netcracker.edu.ssu.homework003.parser.impl.StringParser;
import com.netcracker.edu.ssu.homework003.calculator.api.Calculator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Алексей on 01.11.2016.
 */
public class StringCalculator implements Calculator {

    private Parser parser = new StringParser();
    private CheckerAndConsider functional = new Functional();

    @Override
    public int calculate(String line) {
        List<String> expressions = new LinkedList<>();
        List<Character> operators = new LinkedList<>();

        int firstNumber;
        int secondNumber;
        int result = 0;

        parser.parse(line, expressions, operators);


        if (expressions.size() == 1 && functional.isNumber(expressions.get(0))) {
            return Integer.parseInt(expressions.get(0));
        } else if (expressions.size() == 1 && !functional.isNumber(expressions.get(0))) {
            return calculate(expressions.get(0).substring(1, expressions.get(0).length() - 1));
        }

        boolean isFirstSteep = true;

        for (int i = 0; i < operators.size(); i++) {
            if (functional.isHardOperator(operators.get(i)) && isFirstSteep
                    || functional.isEasyOperator(operators.get(i)) && !isFirstSteep) {

                if (functional.isNumber(expressions.get(i))) {
                    firstNumber = Integer.parseInt(expressions.get(i));
                } else {
                    firstNumber = calculate(expressions.get(i).substring(1, expressions.get(0).length() - 1));
                }
                expressions.remove(i);

                if (functional.isNumber(expressions.get(i))) {
                    secondNumber = Integer.parseInt(expressions.get(i));
                } else {
                    secondNumber = calculate(expressions.get(i).substring(1, expressions.get(i).length() - 1));
                }
                expressions.remove(i);

                result = functional.count(firstNumber, secondNumber, operators.get(i));
                operators.remove(i);

                if (expressions.isEmpty()) {
                    break;
                } else {
                    expressions.add(i, "" + result);
                }

                //don't ask, magic
                if (!operators.isEmpty()) {
                    i--;
                }
            }
            //don't ask, magic
            if (!operators.isEmpty() && i + 1 == operators.size() && isFirstSteep) {
                isFirstSteep = false;
                i = -1;
            }
        }

        return result;
    }
}
