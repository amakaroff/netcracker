package com.netcracker.edu.ssu.task004.part003.grouping.api;

import java.util.List;
import java.util.Map;

/**
 * Created by Алексей on 08.11.2016.
 */
public interface Grouping {

    Map<String, List<String>> group(List<String> words);
}
