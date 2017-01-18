package ru.habrahabr.sergiosergio.main;

import ru.habrahabr.sergiosergio.display.Display;
import ru.habrahabr.sergiosergio.game.Game;

import javax.swing.Timer;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;


/**
 * Created by sg on 14.01.2017.
 */
public class Main {

    public static void main(String[] args){

        Game tanks = new Game();
        tanks.start();



    }
}
