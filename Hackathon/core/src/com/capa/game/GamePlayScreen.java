package com.capa.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.capa.game.util.Assets;
import com.capa.game.util.Constants;

/**
 * Created by prudhvir on 08-10-2016.
 */
public class GamePlayScreen extends ScreenAdapter {
    public static final String TAG = GamePlayScreen.class.getName();

    Level level;
    SpriteBatch batch;
    public ExtendViewport viewport;

    @Override
    public void show() {
        AssetManager am = new AssetManager();
        Assets.instance.init(am);

        // TODO: Initialize Level
        level = new Level();
        batch = new SpriteBatch();
        viewport = new ExtendViewport(Constants.WORLD_SIZE, (9.0f/16.0f)*Constants.WORLD_SIZE);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        Assets.instance.dispose();
    }

    @Override
    public void render(float delta) {
        // TODO: Call update() on the Level
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        level.update(delta);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        // TODO: Render the Level
        level.render(batch);
        batch.end();
    }
}
