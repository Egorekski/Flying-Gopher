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
    Gopher gopher;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("gopher.png");
        gopher = new Gopher(0, 0, 7, 5);
    }

    @Override
    public void render() {
        // actions with objects
        gopher.fly();

        // drawing
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, gopher.x, gopher.y, gopher.IMG_WIDTH, gopher.IMG_HEIGHT);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
