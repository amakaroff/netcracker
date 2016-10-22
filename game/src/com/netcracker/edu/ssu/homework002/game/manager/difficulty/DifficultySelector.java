package com.netcracker.edu.ssu.homework002.game.manager.difficulty;

import com.netcracker.edu.ssu.homework002.game.bean.BeanHolder;
import com.netcracker.edu.ssu.homework002.game.config.Config;
import com.netcracker.edu.ssu.homework002.game.generator.Generator;
import com.netcracker.edu.ssu.homework002.game.model.Messages;
import com.netcracker.edu.ssu.homework002.game.view.api.View;

/**
 * Created by Alexey on 21.10.2016.
 */

public class DifficultySelector {

    private static int difficulty = -1;

    private static View view = BeanHolder.VIEW_INSTANCE.getBean();

    private DifficultySelector() {
    }

    public static void setDifficulty(int difficulty) {
        DifficultySelector.difficulty = difficulty;
    }

    public static void select() {
        difficultyReader();

        switch (difficulty) {
            case 1:
                Config.setRight(30);
                break;
            case 2:
                Config.setRight(60);
                break;
            case 3:
                Config.setRight(100);
                break;
            case 4:
                view.print(Messages.ENTER_RANGE, true);
                selectRange();
                break;
        }

        Generator.setGenerateKey();
    }

    private static void selectRange() {
        String[] range = new String[8]; // any length, except two

        while (Config.getRight() < Config.getLeft() || range.length != 2) {
            try {
                range = view.read().split(" ");
                Config.setLeft(Integer.parseInt(range[0]));
                Config.setRight(Integer.parseInt(range[1]));

                if (Config.getRight() < Config.getLeft() || range.length != 2) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException exception) {
                view.print(Messages.WRONG_ENTER, true);
            } catch (IllegalArgumentException exception) {
                view.print(Messages.WRONG_NUMBER_ENTER, true);
            }
        }
    }

    private static void difficultyReader() {
        while (difficulty < 1 || difficulty > 4) {
            try {
                difficulty = Integer.parseInt(view.read());

                if (difficulty < 1 || difficulty > 4) {
                    throw new IllegalArgumentException();
                }

            } catch (NumberFormatException exception) {
                view.print(Messages.WRONG_ENTER, true);
            } catch (IllegalArgumentException exception) {
                view.print(Messages.WRONG_NUMBER_ENTER, true);
            }
        }
    }
}
