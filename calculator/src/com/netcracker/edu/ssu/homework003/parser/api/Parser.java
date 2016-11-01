package com.netcracker.edu.ssu.homework003.parser.api;

import java.util.List;

/**
 * Created by Алексей on 01.11.2016.
 */
public interface Parser {

    void parse(String line, List<String> expressions, List<Character> operators);
}
