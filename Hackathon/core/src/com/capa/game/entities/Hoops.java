package com.capa.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.capa.game.util.Assets;
import com.capa.game.util.Constants;

/**
 * Created by prudhvir on 08-10-2016.
 */
public class Hoops {
    public static final String TAG = Hoops.class.getName();

    Vector2 position;
    float velocity;
    Direction direction;
    Texture hoops;

    public Hoops(){
        position = new Vector2(Constants.WORLD_SIZE * 0.5f,Constants.WORLD_SIZE * 0.5f);
        velocity = Constants.HOOP_SPEED;
        direction = Direction.RIGHT;
        hoops  = new Texture(Constants.HOOP);
    }

    public void update(float delta) {
        if(direction == Direction.RIGHT){
            position.x += Constants.HOOP_SPEED * delta;
        }
        if(direction == Direction.LEFT){
            position.x -= Constants.HOOP_SPEED * delta;
        }

        if(position.x < 0.1f * Constants.WORLD_SIZE){
            direction = Direction.RIGHT;
            position.x = 0.1f * Constants.WORLD_SIZE;
        }
        if(position.x > Constants.WORLD_SIZE - 0.1f * Constants.WORLD_SIZE){
            direction = Direction.LEFT;
            position.x = Constants.WORLD_SIZE - 0.1f * Constants.WORLD_SIZE;
        }
    }

    public void render(SpriteBatch batch){

        batch.draw(hoops, position.x, position.y, 0.2f * Constants.WORLD_SIZE, 0.2f*Constants.WORLD_SIZE);
    }

    public enum Direction{
        LEFT,RIGHT
    }
}
