package com.netcracker.edu.ssu.homework002.game.manager.hint;

import com.netcracker.edu.ssu.homework002.game.config.Config;
import com.netcracker.edu.ssu.homework002.game.generator.Generator;
import com.netcracker.edu.ssu.homework002.game.model.Messages;

/**
 * Created by Alexey on 21.10.2016.
 */

public class HintManager {

    private HintManager() {
    }

    public static String getHint(boolean isHint) {
        int random = Generator.getRandomNumber(Config.getLeft(), Config.getRight());
        if (isHint) {
            if (random > Config.getWinNumber()) {
                return String.format(Messages.PATTERN_HINT, Messages.LOWER, random);
            } else {
                return String.format(Messages.PATTERN_HINT, Messages.OVER, random);
            }
        } else {
            String[] casual = {Messages.LOWER, Messages.OVER};
            return String.format(Messages.PATTERN_HINT, casual[Generator.getRandomNumber(0, 1)], random);
        }
    }
}
