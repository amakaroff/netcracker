package com.netcracker.edu.ssu.homework002.game;

import com.netcracker.edu.ssu.homework002.game.bean.BeanHolder;
import com.netcracker.edu.ssu.homework002.game.config.Config;
import com.netcracker.edu.ssu.homework002.game.generator.Generator;
import com.netcracker.edu.ssu.homework002.game.manager.Manager;
import com.netcracker.edu.ssu.homework002.game.manager.difficulty.DifficultySelector;
import com.netcracker.edu.ssu.homework002.game.model.Messages;
import com.netcracker.edu.ssu.homework002.game.view.api.View;

/**
 * Created by Alexey on 21.10.2016.
 */

public class Game {

    private View view = BeanHolder.VIEW_INSTANCE.getBean();

    public Game() {
    }

    public void play() {
        view.print(Messages.INTRODUCTION, true);
        view.print(Messages.NEXT, true);
        view.read();

        view.print(Messages.HELP_MESSAGE, true);
        view.print(Messages.NEXT, true);
        view.read();

        while (true) {
            Config.resetAll();

            view.print(Messages.DIFFICULTY, true);
            DifficultySelector.select();

            boolean isComplete = true;

            Config.setPoints((Config.getRight() - Config.getLeft() + 1) * 10);
            Config.setMaxPoints(Config.getPoints());
            Config.setWinNumber(Generator.getRandomNumber(Config.getLeft(), Config.getRight()));

            while (isComplete) {
                view.print(Messages.ENTER_COMMAND, true);
                isComplete = Manager.manage(view.read());
            }

            view.print(String.format(Messages.PLAYER_STATISTICS, Config.getCount(), Config.getPoints()), true);

            view.print(Messages.NEXT_GAME, true);
            Manager.toNextGame();
        }
    }
}
