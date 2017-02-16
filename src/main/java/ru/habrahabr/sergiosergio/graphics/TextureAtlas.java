package ru.habrahabr.sergiosergio.graphics;

import ru.habrahabr.sergiosergio.utils.ResourceLoader;

import java.awt.image.BufferedImage;

/**
 * Created by sgrimanov on 16.02.2017.
 */
public class TextureAtlas {

    BufferedImage image;
    public TextureAtlas(String imageName){
        image = ResourceLoader.loadImage(imageName);
    }

    public BufferedImage cut(int x, int y, int w, int h){
        return image.getSubimage(x, y, w, h);
    }
}
