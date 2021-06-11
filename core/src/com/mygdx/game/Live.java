package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Live extends ApplicationAdapter {

	public static float SCREEN_WIDTH = 500;
	public static float SCREEN_HEIGHT = 500;

	public Draw draw;
	
	@Override
	public void create () {
		draw = new Draw();
	}

	@Override
	public void render() {
		draw.render();
	}
	
	@Override
	public void dispose () {
		draw.dispose();
	}
}
