package ru.habrahabr.sergiosergio.display;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Dimension;

/**
 * Created by sg on 14.01.2017.
 */
public abstract class Display {

    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;

    public static void create (int width, int height, String title){

        if(created){

            return;
        }

        window = new JFrame(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content = new Canvas();

        Dimension size = new Dimension(width, height);
        content.setPreferredSize(size);
        window.setResizable(false);
        window.getContentPane().add(content);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
