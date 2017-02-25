package ru.habrahabr.sergiosergio.game.level;

/**
 * Created by sg on 24.02.2017.
 */
public enum TileType {

    EMPTY(0), BRICK(1), METAL(2), WATER(3), GRASS(4), ICE(5);

    private int n;

    TileType(int n){

        this.n = n;
    }

    public int numeric(){

        return n;
    }

    public static TileType fromNumeric(int n){

        switch (n){
            case 1:
                return BRICK;
            case 2:
                return BRICK;
            case 3:
                return BRICK;
            case 4:
                return BRICK;
            case 5:
                return BRICK;
            default:
                return EMPTY;
        }
    }
}
