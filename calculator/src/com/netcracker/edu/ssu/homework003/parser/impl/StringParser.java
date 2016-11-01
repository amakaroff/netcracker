package com.netcracker.edu.ssu.homework003.parser.impl;

import com.netcracker.edu.ssu.homework003.functional.api.CheckerAndConsider;
import com.netcracker.edu.ssu.homework003.functional.impl.Functional;
import com.netcracker.edu.ssu.homework003.parser.api.Parser;

import java.util.List;

/**
 * Created by Алексей on 01.11.2016.
 */
public class StringParser implements Parser {

    private CheckerAndConsider functional = new Functional();

    @Override
    public void parse(String line, List<String> expressions, List<Character> operators) {
        int length = 0;
        int count = 0;

        if (line.charAt(0) == '+' || line.charAt(0) == '-') {
            length++;
            count++;
            if (length < line.length() && line.charAt(length) == '(') {
                line = '(' + (line.charAt(0) + line.substring(length + 1, line.length() - 1));
                length++;
                if (line.charAt(length - 1) == '-' && line.charAt(length) == '-') {
                    line = line.substring(length + 1, line.length());
                    expressions.add(line);
                    return;
                }
            }
        }

        //very difficult logic
        while (length < line.length()) {
            if (line.charAt(length) == '(') {
                int countOpenBracket = 1;
                length++;
                count++;
                while (countOpenBracket > 0) {
                    if (line.charAt(length) == '(') {
                        countOpenBracket++;
                    } else if (line.charAt(length) == ')') {
                        countOpenBracket--;
                    }
                    length++;
                    count++;
                }
                expressions.add(line.substring(length - count, length));
                count = 0;
                if (length < line.length()) {
                    operators.add(line.substring(length, length + 1).charAt(0));
                }
            } else {
                while (length < line.length() && !functional.isEasyOperator(line.charAt(length))
                        && !functional.isHardOperator(line.charAt(length))) {
                    length++;
                    count++;
                }
                expressions.add(line.substring(length - count, length));
                count = 0;
                if (length < line.length()) {
                    operators.add(line.substring(length, length + 1).charAt(0));
                }
            }
            length++;
        }
    }
}
