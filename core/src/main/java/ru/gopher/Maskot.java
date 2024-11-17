package ru.gopher;

import static ru.gopher.Main.SCREEN_HEIGHT;
import static ru.gopher.Main.SCREEN_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class Maskot {
    public float x, y;
    private float stepX, stepY;
    public final float IMG_WIDTH = 213, IMG_HEIGHT = 213;

    public Maskot(float x, float y) {
        this.x = x;
        this.y = y;
        stepX = MathUtils.random(-9, 9);
        stepY = MathUtils.random(-9, 9);
    }

    public void fly() {
        x += stepX;
        y += stepY;
        if (x > SCREEN_WIDTH - IMG_WIDTH || x < 0) stepX = -stepX;
        if (y > SCREEN_HEIGHT - IMG_HEIGHT || y < 0) stepY = -stepY;
    }

    public boolean isFlip() {
        return !(stepX < 0);
    }
}
