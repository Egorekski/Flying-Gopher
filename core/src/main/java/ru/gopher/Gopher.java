package ru.gopher;

import static ru.gopher.Main.*;

import com.badlogic.gdx.math.MathUtils;

public class Gopher {
    public float x = 0, y = 0;
    public float stepX, stepY;
    public final float IMG_WIDTH = 213, IMG_HEIGHT = 213;

    Gopher() {
        stepX = MathUtils.random(-9, 9);
        stepY = MathUtils.random(-9, 9);
    }

    public void fly() {
        x += stepX;
        y += stepY;
        if (x > SCREEN_WIDTH - IMG_WIDTH || x < 0) stepX = -stepX;
        if (y > SCREEN_HEIGHT - IMG_HEIGHT || y < 0) stepY = -stepY;
    }
}
