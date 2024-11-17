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
    private Texture imgGopher;
    private Texture imgBackground;
    Gopher[] gopher = new Gopher[2];

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgGopher = new Texture("gopher.png");
        imgBackground = new Texture("google.png");
        for (int i = 0; i < gopher.length; i++) {
            gopher[i] = new Gopher(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
        }
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
        batch.draw(imgBackground, SCREEN_WIDTH/2, SCREEN_HEIGHT/2, 213, 213);
        for (Gopher go : gopher) {
            batch.draw(
                imgGopher,
                go.x, go.y,
                go.IMG_WIDTH, go.IMG_HEIGHT,
                0, 0,
                213, 213,
                go.isFlip(), false
                );
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgGopher.dispose();
        imgBackground.dispose();
    }
}
