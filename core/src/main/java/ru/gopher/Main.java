package ru.gopher;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    public static final float SCREEN_WIDTH = 1280;
    public static final float SCREEN_HEIGHT = 720;
    private SpriteBatch batch;
    private Texture imgGopher;
    private Texture imgBackground;
    private Texture imgRust;
    Gopher[] gopher = new Gopher[3];
    Rust[] rust = new Rust[2];

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgGopher = new Texture("gopher.png");
        imgBackground = new Texture("google.png");
        imgRust = new Texture("rust.png");
        for (int i = 0; i < gopher.length; i++) {
            gopher[i] = new Gopher(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
        }
        for (int i = 0; i < rust.length; i++) {
            rust[i] = new Rust(MathUtils.random(0, 700), MathUtils.random(0, 500));
        }
    }

    @Override
    public void render() {
        // actions with objects
        for (Gopher go : gopher) go.fly();
        for (Rust ru : rust) ru.fly();

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

        for (Rust value : rust) {
            batch.draw(
                imgRust,
                value.x, value.y,
                value.IMG_WIDTH, value.IMG_HEIGHT,
                0, 0,
                436, 290,
                value.isFlip(), false
            );
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgGopher.dispose();
        imgBackground.dispose();
        imgRust.dispose();
    }
}
