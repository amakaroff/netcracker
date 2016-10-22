package com.netcracker.edu.ssu.homework002.game.manager.handler.api;

import com.netcracker.edu.ssu.homework002.game.bean.Bean;

/**
 * Created by Alexey on 21.10.2016.
 */

public interface Handler extends Bean {

    boolean handle(String query);
}
