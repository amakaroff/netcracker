package com.netcracker.edu.ssu.homework002.game.generator;

import com.netcracker.edu.ssu.homework002.game.config.Config;
import com.netcracker.edu.ssu.homework002.game.manager.hint.HintManager;
import com.netcracker.edu.ssu.homework002.game.model.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alexey on 21.10.2016.
 */

public class Generator {

    private static int[] dividers;
    private static int generateKey = 0;

    private static List<String> repeatNumbersMessages;

    private static List<String> winMessages;

    private static List<String> loseMessages;

    private static List<String> wrongNumberMessages;

    private static List<String> trueHints;

    private static List<String> falseHints;

    static {
        repeatNumbersMessages = new ArrayList<String>();
        repeatNumbersMessages.add(Messages.REPEAT_SELECT_NUMBER_1);
        repeatNumbersMessages.add(Messages.REPEAT_SELECT_NUMBER_2);
        repeatNumbersMessages.add(Messages.REPEAT_SELECT_NUMBER_3);

        winMessages = new ArrayList<String>();
        winMessages.add(Messages.WIN_MESSAGE_1);
        winMessages.add(Messages.WIN_MESSAGE_2);
        winMessages.add(Messages.WIN_MESSAGE_3);
        winMessages.add(Messages.WIN_MESSAGE_4);
        winMessages.add(Messages.WIN_MESSAGE_5);

        loseMessages = new ArrayList<String>();
        loseMessages.add(Messages.LOSE_MESSAGE_1);
        loseMessages.add(Messages.LOSE_MESSAGE_2);
        loseMessages.add(Messages.LOSE_MESSAGE_3);
        loseMessages.add(Messages.LOSE_MESSAGE_4);
        loseMessages.add(Messages.LOSE_MESSAGE_5);

        wrongNumberMessages = new ArrayList<String>();
        wrongNumberMessages.add(Messages.WRONG_NUMBER_1);
        wrongNumberMessages.add(Messages.WRONG_NUMBER_2);
        wrongNumberMessages.add(Messages.WRONG_NUMBER_3);
        wrongNumberMessages.add(Messages.WRONG_NUMBER_4);
        wrongNumberMessages.add(Messages.WRONG_NUMBER_5);

        trueHints = new ArrayList<String>();
        trueHints.add(Messages.TRUE_HINT_1);
        trueHints.add(Messages.TRUE_HINT_2);
        trueHints.add(Messages.TRUE_HINT_3);
        trueHints.add(Messages.TRUE_HINT_4);
        trueHints.add(Messages.TRUE_HINT_5);

        falseHints = new ArrayList<String>();
        falseHints.add(Messages.FALSE_HINT_1);
        falseHints.add(Messages.FALSE_HINT_2);
        falseHints.add(Messages.FALSE_HINT_3);
        falseHints.add(Messages.FALSE_HINT_4);
        falseHints.add(Messages.FALSE_HINT_5);
    }

    public static void setGenerateKey() {
        int tryCount = (Config.getRight() - Config.getLeft() + 1) / 3;
        if (tryCount % 5 == 0) {
            generateKey = tryCount / 5;
        } else {
            generateKey = tryCount / 5 + 1;
        }
        dividers = new int[5];
        dividers[0] = Config.getLeft() + generateKey;
        for (int i = 1; i < 5; i++) {
            dividers[i] = dividers[i - 1] + generateKey;
        }
    }

    public static int getRandomNumber(int left, int right) {
        return new Random().nextInt(right - left + 1) + left;
    }

    public static String generateWinSentence() {
        return winMessages.get(generateNumberForCount());
    }

    public static String generateLoseSentence() {
        return loseMessages.get(getRandomNumber(0, 4));
    }

    public static String generateWrongNumberSentence() {
        return wrongNumberMessages.get(generateNumberForCount());
    }

    public static int generateNumberForCount() {
        int random = getRandomNumber(0, 2);
        int count = Config.getCount();

        if (count <= dividers[0] && (random == 0 || random == 1) || count > dividers[0] && count <= dividers[1] && random == 2) {
            return 0;
        } else if (count <= dividers[0] && random == 2 ||
                count > dividers[0] && count <= dividers[1] && random == 1 ||
                count > dividers[1] && count <= dividers[2] && random == 0) {
            return 1;
        } else if (count > dividers[0] && count <= dividers[1] && random == 0 ||
                count > dividers[1] && count <= dividers[2] && random == 1 ||
                count > dividers[2] && count <= dividers[3] && random == 2) {
            return 2;
        } else if (count > dividers[1] && count <= dividers[2] && random == 2 ||
                count > dividers[2] && count <= dividers[3] && random == 1 ||
                count > dividers[3] && count <= dividers[4] + 1 && random == 2) {
            return 3;
        } else if (count > dividers[2] && count <= dividers[3] && random == 0 ||
                count <= dividers[4] + 1 && (random == 0 || random == 1)) {
            return 4;
        }
        return 5;
    }

    public static boolean isTrueHint() {
        int length = (Config.getRight() - Config.getLeft() + 1) / 3;
        int count = Config.getCount();

        return getRandomNumber(0, length) <= count;
    }

    public static String generateHint() {
        boolean isTrue = isTrueHint();
        if (isTrue) {
            return String.format(trueHints.get(getRandomNumber(0, 4)), HintManager.getHint(isTrue));
        } else {
            return String.format(falseHints.get(getRandomNumber(0, 4)), HintManager.getHint(isTrue));
        }
    }

    public static String generateRepeatNumberSentence() {
        return repeatNumbersMessages.get(getRandomNumber(0, 2));
    }
}
