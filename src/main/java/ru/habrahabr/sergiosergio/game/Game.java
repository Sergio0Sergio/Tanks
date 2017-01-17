package ru.habrahabr.sergiosergio.game;

import ru.habrahabr.sergiosergio.utils.Time;

/**
 * Created by sg on 17.01.2017.
 */
public class Game implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Tanks";
    public static final int CLEAR_COLOR = 0xff000000;
    public static final int NUMB_UFFERS = 3;

    public static final float UPDATE_RATE = 60.0f;
    public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;





    public Game(){

    }

    public synchronized void start(){

    }

    public synchronized void stop(){

    }

    private void update(){

    }

    private void render(){

    }

    private void cleanup(){

    }

    @Override
    public void run() {

    }
}
