package com.netcracker.edu.ssu.task004.part003.grouping.impl;

import com.netcracker.edu.ssu.task004.part003.grouping.api.Grouping;

import java.util.*;

/**
 * Created by Алексей on 08.11.2016.
 */
public class AnagramGrouping implements Grouping {

    @Override
    public Map<String, List<String>> group(List<String> words) {
        Map<String, List<String>> anagramGroup = new HashMap<>();

        char[] key;
        String wordKey;
        for (String word : words) {
            key = word.toCharArray();
            Arrays.sort(key);
            wordKey = new String(key);
            if (anagramGroup.containsKey(wordKey)) {
                anagramGroup.get(wordKey).add(word);
            } else if (wordKey.length() > 1) {
                anagramGroup.put(wordKey, new ArrayList<>());
                anagramGroup.get(wordKey).add(word);
            }
        }
        return anagramGroup;
    }
}
