package ru.gopher;

import static ru.gopher.Main.*;

public class Gopher {
    public float x, y;
    public float stepX = 7, stepY = 4;
    public final float IMG_WIDTH = 213, IMG_HEIGHT = 213;

    Gopher(float x, float y, float stepX, float stepY) {
        this.x = x;
        this.y = y;
        this.stepX = stepX;
        this.stepY = stepY;
    }

    public void fly() {
        x += stepX;
        y += stepY;
        if (x > SCREEN_WIDTH - IMG_WIDTH || x < 0) stepX = -stepX;
        if (y > SCREEN_HEIGHT - IMG_HEIGHT || y < 0) stepY = -stepY;
    }
}
