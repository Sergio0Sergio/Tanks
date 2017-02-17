package ru.habrahabr.sergiosergio.game;

import ru.habrahabr.sergiosergio.IO.Input;

import java.awt.*;

/**
 * Created by sgrimanov on 17.02.2017.
 */
public abstract class Entity {

    public final EntityType type;
    protected float x;
    protected float y;

    protected Entity (EntityType type, float x, float y){

        this.type = type;
        this.x = x;
        this.y = y;
    }

    protected abstract void update(Input input);

    protected abstract void render(Graphics2D g);
}
