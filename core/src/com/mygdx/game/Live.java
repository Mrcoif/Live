package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MainMenu.MainMenuScreen;

public class Live extends Game {

	public static float SCREEN_WIDTH = 500;
	public static float SCREEN_HEIGHT = 500;

	public static Vector3 touchPos;

	public OrthographicCamera camera;
	public SpriteBatch batch;
	public BitmapFont font;
	public BitmapFont arrowFont;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
		camera.translate(0, 0);

		font = new BitmapFont(Gdx.files.internal("font/font.fnt"));
		font.setColor(Color.BLACK);
		arrowFont = new BitmapFont(Gdx.files.internal("font/arrow.fnt"));
		arrowFont.setColor(Color.BLACK);

		touchPos = new Vector3();

		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();

		batch.begin();
		//font.draw(batch, "Aasd", 275,SCREEN_HEIGHT - 5);
		batch.end();

		touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(touchPos);
		camera.update();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		font.dispose();
	}
}
