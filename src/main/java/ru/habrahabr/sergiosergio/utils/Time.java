package ru.habrahabr.sergiosergio.utils;

/**
 * Created by sg on 17.01.2017.
 */
public class Time {

    public static final long SECOND = 1000000000l;

    public static long get(){
        return System.nanoTime();
    }
}
