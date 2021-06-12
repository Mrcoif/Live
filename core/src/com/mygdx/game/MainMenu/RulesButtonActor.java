package com.mygdx.game.MainMenu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;
import com.mygdx.game.UserInterface.BaseButtonActor;

public class RulesButtonActor  extends BaseButtonActor {

    private MainMenuScreen mainMenuScreen;

    public RulesButtonActor(MainMenuScreen mainMenuScreen) {
        super("buttons/rules.png", new Rectangle(240, 110, 200, 100));
        this.mainMenuScreen = mainMenuScreen;
    }

    @Override
    protected void function() {

    }
}
