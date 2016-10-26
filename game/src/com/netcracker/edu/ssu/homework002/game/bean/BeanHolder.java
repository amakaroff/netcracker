package com.netcracker.edu.ssu.homework002.game.bean;

import com.netcracker.edu.ssu.homework002.game.manager.handler.impl.HandlerCommand;
import com.netcracker.edu.ssu.homework002.game.manager.handler.impl.HandlerNumbers;
import com.netcracker.edu.ssu.homework002.game.view.api.View;
import com.netcracker.edu.ssu.homework002.game.view.impl.ConsoleView;

/**
 * Created by Alexey on 21.10.2016.
 */

public enum BeanHolder {

    VIEW_INSTANCE(ConsoleView.getInstance()),
    COMMAND_HANDLER_INSTANCE(HandlerCommand.getInstance()),
    NUMBER_HANDLER_INSTANCE(HandlerNumbers.getInstance());

    private Bean bean;

    BeanHolder(Bean bean) {
        this.bean = bean;
    }

    public <T extends Bean> T getBean() {
        return (T) bean;
    }
}
