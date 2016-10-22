package com.netcracker.edu.ssu.homework002.game.manager.handler.impl;

import com.netcracker.edu.ssu.homework002.game.bean.BeanHolder;
import com.netcracker.edu.ssu.homework002.game.config.Config;
import com.netcracker.edu.ssu.homework002.game.generator.Generator;
import com.netcracker.edu.ssu.homework002.game.manager.handler.api.Handler;
import com.netcracker.edu.ssu.homework002.game.view.api.View;

/**
 * Created by Alexey on 21.10.2016.
 */

public class HandlerNumbers implements Handler {

    private static final HandlerNumbers INSTANCE = new HandlerNumbers();

    private static View view;

    static {
        view = BeanHolder.VIEW_INSTANCE.getBean();
    }

    private HandlerNumbers() {
    }

    public static HandlerNumbers getInstance() {
        return INSTANCE;
    }

    public boolean handle(String query) {
        int selectNumber = Integer.parseInt(query);
        int lengthRange = Config.getRight() - Config.getLeft() + 1;
        Config.setCount(Config.getCount() + 1);

        if (Config.getPoints() < 0) {
            view.print(Generator.generateLoseSentence(), true);
            Config.setPoints(0);
            return false;
        }

        if (Config.isUsedNumber(selectNumber)) {
            view.print(Generator.generateRepeatNumberSentence(), true);
            Config.setPoints(Config.getPoints() - ((lengthRange / (lengthRange / 3)) * 10));
            return true;
        }
        Config.addUsedNumbers(selectNumber);

        if (selectNumber == Config.getWinNumber()) {
            view.print(Generator.generateWinSentence(), true);
            return false;
        } else {
            view.print(Generator.generateWrongNumberSentence(), true);
            Config.setPoints(Config.getPoints() - ((lengthRange / (lengthRange / 3)) * 10));
        }
        return true;
    }
}
