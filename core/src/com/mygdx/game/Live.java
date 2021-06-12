package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Live extends Game {

	public static float SCREEN_WIDTH = 500;
	public static float SCREEN_HEIGHT = 500;

	public static Vector3 touchPos;

	public OrthographicCamera camera;
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
		camera.translate(0, 0);

		touchPos = new Vector3();

		setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render();

		//System.out.println(touchPos.toString());
		touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(touchPos);
		camera.update();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
	}
}
