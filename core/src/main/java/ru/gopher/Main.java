package ru.gopher;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    public static final float SCREEN_WIDTH = 1280;
    public static final float SCREEN_HEIGHT = 720;
    private SpriteBatch batch;
    private Texture image;
    private float x = 0, y = 0;
    private float stepX = 7, stepY = 4;
    private final float IMG_WIDTH = 213, IMG_HEIGHT = 213;
    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("gopher.png");
    }

    @Override
    public void render() {
        x += stepX;
        y += stepY;
        if (x > SCREEN_WIDTH - IMG_WIDTH || x < 0) stepX = -stepX;
        if (y > SCREEN_HEIGHT - IMG_HEIGHT || y < 0) stepY = -stepY;

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, x, y, IMG_WIDTH, IMG_HEIGHT);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
