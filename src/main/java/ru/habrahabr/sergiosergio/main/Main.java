package ru.habrahabr.sergiosergio.main;

import ru.habrahabr.sergiosergio.display.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Timer;

/**
 * Created by sg on 14.01.2017.
 */
public class Main {

    public static void main(String[] args){

        Display.create(800, 600, "Tanks!", 0xff00ff00);

        Timer t = new Timer(1000 / 60, new AbstractAction(){

            public void actionPerformed(ActionEvent e){
                Display.clear();
                Display.render();
                Display.swapBuffers();
            }
        }
    }
}
