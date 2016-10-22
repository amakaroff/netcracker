package com.netcracker.edu.ssu.homework002.game.view.api;

import com.netcracker.edu.ssu.homework002.game.bean.Bean;

/**
 * Created by Alexey on 21.10.2016.
 */

public interface View extends Bean {

    void print(String data, boolean toNextLine);

    String read();
}
