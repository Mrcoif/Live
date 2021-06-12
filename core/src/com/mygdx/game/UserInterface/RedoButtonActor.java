package com.mygdx.game.UserInterface;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;

public class RedoButtonActor extends BaseButtonActor {

    private GameScreen gameScreen;

    public RedoButtonActor(GameScreen gameScreen) {
        super("buttons/redo.png", new Rectangle(375,215,100,100));
        this.gameScreen = gameScreen;
    }

    @Override
    protected void function() {
        gameScreen.logic.generateNewLayer();
    }
}
