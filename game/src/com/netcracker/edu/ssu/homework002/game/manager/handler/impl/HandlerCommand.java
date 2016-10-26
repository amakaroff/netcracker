package com.netcracker.edu.ssu.homework002.game.manager.handler.impl;

import com.netcracker.edu.ssu.homework002.game.bean.BeanHolder;
import com.netcracker.edu.ssu.homework002.game.config.Config;
import com.netcracker.edu.ssu.homework002.game.generator.Generator;
import com.netcracker.edu.ssu.homework002.game.manager.handler.api.Handler;
import com.netcracker.edu.ssu.homework002.game.model.Messages;
import com.netcracker.edu.ssu.homework002.game.view.api.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexey on 21.10.2016.
 */

public class HandlerCommand implements Handler {

    private static final HandlerCommand INSTANCE = new HandlerCommand();

    private static Map<String, Integer> commands;
    private static View view;

    static {
        view = BeanHolder.VIEW_INSTANCE.getBean();

        commands = new HashMap<String, Integer>();
        commands.put(Messages.POINTS, 1);
        commands.put(Messages.USED, 2);
        commands.put(Messages.HELP, 3);
        commands.put(Messages.HINT, 4);
        commands.put(Messages.EXIT, 5);
    }

    private HandlerCommand() {
    }

    public static HandlerCommand getInstance() {
        return INSTANCE;
    }

    public boolean handle(String command) {
        if (command != null)
            command = command.toLowerCase();
        if (commands.containsKey(command)) {
            switch (commands.get(command)) {
                case 1:
                    view.print(String.format(Messages.YOU_POINTS, Config.getPoints(), Config.getMaxPoints()), true);
                    break;
                case 2:
                    if (Config.isUsedNumbersEmpty()) {
                        view.print(Messages.EMPTY_ENTER, false);
                    } else {
                        for (int used : Config.getUsedNumbers()) {
                            view.print(used + " ", false);
                        }
                    }

                    view.print("", true);
                    break;
                case 3:
                    view.print(Messages.HELP_MESSAGE, true);
                    break;
                case 4:
                    view.print(Generator.generateHint(), true);
                    break;
                case 5:
                    view.print(Generator.generateLoseSentence(), true);
                    return false;
            }
            return true;
        } else {
            view.print(Messages.WRONG_ENTER, true);
            return true;
        }
    }
}
