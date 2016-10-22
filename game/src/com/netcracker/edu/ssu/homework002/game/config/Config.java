package com.netcracker.edu.ssu.homework002.game.config;

import com.netcracker.edu.ssu.homework002.game.manager.difficulty.DifficultySelector;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Alexey on 21.10.2016.
 */

public class Config {

    private static int winNumber;

    private static int left = 0;
    private static int right = 0;
    private static int count = 0;

    private static int points = 0;

    private static Set<Integer> usedNumbers = new TreeSet<Integer>();

    public static int getWinNumber() {
        return winNumber;
    }

    public static void setWinNumber(int winNumber) {
        Config.winNumber = winNumber;
    }

    public static int getLeft() {
        return left;
    }

    public static void setLeft(int left) {
        Config.left = left;
    }

    public static int getRight() {
        return right;
    }

    public static void setRight(int right) {
        Config.right = right;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Config.count = count;
    }

    public static int getPoints() {
        return points;
    }

    public static void setPoints(int points) {
        Config.points = points;
    }

    public static void addUsedNumbers(int usedNumber) {
        Config.usedNumbers.add(usedNumber);
    }

    public static boolean isUsedNumber(int selectNumber) {
        return Config.usedNumbers.contains(selectNumber);
    }

    public static boolean isUsedNumbersEmpty() {
        return Config.usedNumbers.isEmpty();
    }

    public static Set<Integer> getUsedNumbers() {
        return new HashSet<>(usedNumbers);
    }

    public static void resetAll() {
        left = 1;
        right = 1;
        count = 0;
        points = 0;

        DifficultySelector.setDifficulty(-1);

        usedNumbers = new TreeSet<Integer>();
    }
}
