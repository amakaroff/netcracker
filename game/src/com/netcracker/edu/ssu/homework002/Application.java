package com.netcracker.edu.ssu.homework002;

import com.netcracker.edu.ssu.homework002.game.Game;
import com.netcracker.edu.ssu.homework002.game.config.Config;

/**
 * Created by Alexey on 21.10.2016.
 */

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
