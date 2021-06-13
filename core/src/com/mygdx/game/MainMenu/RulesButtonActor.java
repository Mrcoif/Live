package com.mygdx.game.MainMenu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;
import com.mygdx.game.UserInterface.BaseButtonActor;

import static com.mygdx.game.Live.SCREEN_HEIGHT;
import static com.mygdx.game.Live.SCREEN_WIDTH;

public class RulesButtonActor  extends BaseButtonActor {

    private MainMenuScreen mainMenuScreen;

    public RulesButtonActor(MainMenuScreen mainMenuScreen) {
        super("buttons/rules.png", new Rectangle(SCREEN_WIDTH/4, SCREEN_HEIGHT/3,SCREEN_WIDTH/4 * 2, 100));
        this.mainMenuScreen = mainMenuScreen;
    }

    @Override
    protected void function() {

    }
}
