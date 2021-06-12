package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Live;

import static com.mygdx.game.Live.SCREEN_HEIGHT;
import static com.mygdx.game.Live.SCREEN_WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		SCREEN_WIDTH = 480;
		SCREEN_HEIGHT = 800;
		config.width = (int) SCREEN_WIDTH;
		config.height = (int) SCREEN_HEIGHT;
		new LwjglApplication(new Live(), config);
	}
}
