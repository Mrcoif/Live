package com.mygdx.game.MainMenu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;
import com.mygdx.game.UserInterface.BaseButtonActor;

import static com.mygdx.game.Live.SCREEN_HEIGHT;
import static com.mygdx.game.Live.SCREEN_WIDTH;

public class StartButtonActor extends BaseButtonActor {

    private MainMenuScreen mainMenuScreen;

    public StartButtonActor(MainMenuScreen mainMenuScreen) {
        super("buttons/start.png", new Rectangle(SCREEN_WIDTH/4, SCREEN_HEIGHT/3 * 2,SCREEN_WIDTH/4 * 2, 100));
        this.mainMenuScreen = mainMenuScreen;
    }

    @Override
    protected void function() {
        mainMenuScreen.live.setScreen(new GameScreen(mainMenuScreen.live));
    }
}
