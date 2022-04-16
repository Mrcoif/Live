package com.mygdx.game.MainMenu;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;
import com.mygdx.game.UserInterface.BaseButtonActor;

import static com.mygdx.game.Live.SCREEN_HEIGHT;
import static com.mygdx.game.Live.SCREEN_WIDTH;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RulesButtonActor  extends BaseButtonActor {

    private MainMenuScreen mainMenuScreen;

    public RulesButtonActor(MainMenuScreen mainMenuScreen) {
        super(new Vector2(SCREEN_WIDTH/4, SCREEN_HEIGHT/3), "rules", mainMenuScreen.live.font);
        this.mainMenuScreen = mainMenuScreen;
    }
}
