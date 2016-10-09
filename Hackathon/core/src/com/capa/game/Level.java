package com.capa.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.capa.game.entities.Ball;
import com.capa.game.entities.Hoops;
import com.capa.game.util.Assets;
import com.capa.game.util.Constants;

/**
 * Created by prudhvir on 08-10-2016.
 */
public class Level {
    Ball ball;
    Hoops hoops;

    public Level(){
        ball = new Ball();
        hoops = new Hoops();
    }

    public void update(float delta){
        ball.update(delta);
        hoops.update(delta);
    }

    public void render(SpriteBatch batch){
        Texture background = Assets.instance.levelAssets.background;
        Texture powerbar = Assets.instance.levelAssets.powerbar;
        Texture marker = Assets.instance.levelAssets.marker;

        batch.draw(background, 0, 0,Constants.WORLD_SIZE, (9.0f/16.0f)*Constants.WORLD_SIZE);
        batch.draw(powerbar, 0.95f * Constants.WORLD_SIZE, 0.25f * Constants.WORLD_SIZE);

        hoops.render(batch);
        ball.render(batch);
    }
}
