package com.netcracker.edu.ssu.task004.part003;

import com.netcracker.edu.ssu.task004.part003.grouping.api.Grouping;
import com.netcracker.edu.ssu.task004.part003.grouping.impl.AnagramGrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("abc");
        words.add("nmn");
        words.add("cba");
        words.add("nnm");
        words.add("bca");

        Grouping group = new AnagramGrouping();

        for (Map.Entry<String, List<String>> value : group.group(words).entrySet()) {
            if (value.getValue().size() > 1) {
                for (String word : value.getValue()) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }
    }
}
