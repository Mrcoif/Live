package com.mygdx.game.MainMenu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;
import com.mygdx.game.UserInterface.BaseButtonActor;

public class StartButtonActor extends BaseButtonActor {

    private MainMenuScreen mainMenuScreen;

    public StartButtonActor(MainMenuScreen mainMenuScreen) {
        super("buttons/start.png", new Rectangle(240, 110, 200, 100));
        this.mainMenuScreen = mainMenuScreen;
    }

    @Override
    protected void function() {
        mainMenuScreen.live.setScreen(new GameScreen(mainMenuScreen.live));
    }
}
