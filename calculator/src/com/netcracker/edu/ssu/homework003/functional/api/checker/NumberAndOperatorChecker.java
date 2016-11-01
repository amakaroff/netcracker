package com.netcracker.edu.ssu.homework003.functional.api.checker;

/**
 * Created by Алексей on 01.11.2016.
 */
public interface NumberAndOperatorChecker {

    boolean isNumber(String expression);

    boolean isEasyOperator(char sign);

    boolean isHardOperator(char sign);
}
