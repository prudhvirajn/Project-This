package com.capa.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

import javax.xml.soap.Text;

/**
 * Created by prudhvir on 08-10-2016.
 */
public class Assets implements Disposable, AssetErrorListener {
    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    public BallAssets ballAssets;
    public HoopAssets hoopAssets;
    public LevelAssets levelAssets;

    private AssetManager assetManager;

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);

        assetManager.finishLoading();
        ballAssets = new BallAssets(Constants.BALL_SPRITE);
        levelAssets = new LevelAssets();
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {

    }

    public class BallAssets {
        public final Texture ball;
        public BallAssets(String sprite){
            ball = new Texture(sprite);
        }

    }
    public class HoopAssets{
        public final Texture hoop;
        public HoopAssets(){
            hoop = new Texture(Constants.HOOP);
        }
    }
    public class LevelAssets{
        public final Texture background;
        public final Texture powerbar;
        public final Texture marker;
        public LevelAssets(){
            background = new Texture(Constants.BACKGROUND_SPRITE);
            powerbar = new Texture(Constants.POWERBAR_SPRITE);
            marker = new Texture(Constants.MARKER);

        }
    }
}
