package com.netcracker.edu.ssu.homework002.game.manager;

import com.netcracker.edu.ssu.homework002.game.bean.BeanHolder;
import com.netcracker.edu.ssu.homework002.game.manager.handler.api.Handler;
import com.netcracker.edu.ssu.homework002.game.model.Messages;
import com.netcracker.edu.ssu.homework002.game.view.api.View;

/**
 * Created by Alexey on 21.10.2016.
 */

public class Manager {

    private static final Handler numbersHandler = BeanHolder.NUMBER_HANDLER_INSTANCE.getBean();

    private static final Handler commandHandler = BeanHolder.COMMAND_HANDLER_INSTANCE.getBean();

    private static final View view = BeanHolder.VIEW_INSTANCE.getBean();

    private Manager() {
    }

    public static boolean manage(String query) {
        try {
            Integer.parseInt(query);
            return numbersHandler.handle(query);
        } catch (NumberFormatException exception) {
            return commandHandler.handle(query);
        }
    }

    public static void toNextGame() {
        while (true) {
            String answer = view.read();
            if (answer.equalsIgnoreCase("нет")) {
                System.exit(0);
            } else if (answer.equalsIgnoreCase("да")) {
                return;
            } else {
                view.print(Messages.WRONG_ENTER, true);
            }
        }
    }
}
