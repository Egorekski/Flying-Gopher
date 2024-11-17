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
    Gopher[] gopher = new Gopher[2];

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("gopher.png");
        gopher[0] = new Gopher();
        gopher[1] = new Gopher();
    }

    @Override
    public void render() {
        // actions with objects
        for (Gopher go : gopher) {
            go.fly();
        }

        // drawing
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        for (Gopher go : gopher) {
            batch.draw(image, go.x, go.y, go.IMG_WIDTH, go.IMG_HEIGHT);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
