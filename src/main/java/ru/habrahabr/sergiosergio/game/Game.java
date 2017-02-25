package ru.habrahabr.sergiosergio.game;

import ru.habrahabr.sergiosergio.IO.Input;
import ru.habrahabr.sergiosergio.display.Display;
import ru.habrahabr.sergiosergio.game.level.Level;
import ru.habrahabr.sergiosergio.graphics.Sprite;
import ru.habrahabr.sergiosergio.graphics.SpriteSheet;
import ru.habrahabr.sergiosergio.graphics.TextureAtlas;
import ru.habrahabr.sergiosergio.utils.Time;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

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
    public static final long IDLE_TIME = 1;

    public static final String ATLAS_FILE_NAME = "texture_atlas.png";

    private boolean running;
    private Thread gameThread;
    private Graphics2D graphics;
    private Input input;
    private TextureAtlas atlas;
    public Player player;
    private Level lvl;


     public Game(){

        running = false;
        Display.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUMB_UFFERS);
        graphics = Display.getGraphics();
        input = new Input();
        Display.addInputListener(input);
        atlas = new TextureAtlas(ATLAS_FILE_NAME);
        player = new Player(300, 300, 2, 3, atlas );
        lvl = new Level(atlas);


    }

    public synchronized void start(){

        if (running){

            return;
        }

        running = true;
        gameThread = new Thread(this);
        gameThread.start();

    }

    public synchronized void stop(){

        if(!running){

            return;
        }

        running = false;
        try {
            gameThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        cleanUp();


    }

    private void update(){

        player.update(input);
        lvl.update();
    }

    private void render(){
        Display.clear();
        lvl.render(graphics);
        player.render(graphics);
        Display.swapBuffers();
    }

    private void cleanUp(){

        Display.destroy();
    }

    @Override
    public void run() {
        int fps = 0;
        int upd = 0;
        int updl = 0;

        long count = 0;

        float delta = 0;

        long lastTime = Time.get();
        while (running){

            long now = Time.get();
            long elapsedTime = now - lastTime;
            lastTime = now;

            count += elapsedTime;

            boolean render = false;
            delta += (elapsedTime / UPDATE_INTERVAL);
            while (delta > 1){

                update();
                upd ++;
                delta --;
                if(render) {
                    updl ++;
                }else{
                    render = true;
                }
            }

            if(render){

                render();
                fps ++;
            }else {

                try {
                    Thread.sleep(IDLE_TIME);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            if (count >=Time.SECOND){
                Display.setTitle(TITLE +" || Fps: "+fps+" | Upd: "+upd+" | Updl: "+updl);
                upd = 0;
                fps = 0;
                updl = 0;
                count = 0;
            }


        }
    }
}
