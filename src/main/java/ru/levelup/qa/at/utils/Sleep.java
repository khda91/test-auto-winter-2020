package ru.levelup.qa.at.utils;

import java.util.concurrent.TimeUnit;

public class Sleep {

    private Sleep() { }

    public static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
