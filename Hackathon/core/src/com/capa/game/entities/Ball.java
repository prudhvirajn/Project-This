package com.capa.game.entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.capa.game.util.Assets;
import com.capa.game.util.Constants;

/**
 * Created by prudhvir on 08-10-2016.
 */
public class Ball {
    public static final String TAG = Ball.class.getName();

    Vector2 position;



    public Ball(){
        position = Constants.BALL_CENTER;

    }

    public void update(float delta) {

    }

    public void render(SpriteBatch batch){
        Texture ball  = Assets.instance.ballAssets.ball;
        batch.draw(ball, position.x, position.y, 0.2f*Constants.WORLD_SIZE, 0.2f*Constants.WORLD_SIZE);
    }
}
