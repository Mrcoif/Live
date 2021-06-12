package com.mygdx.game.UserInterface;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;

public class ClearButtonActor extends BaseButtonActor{

    private GameScreen gameScreen;

    public ClearButtonActor(GameScreen gameScreen) {
        super("buttons/clear.png", new Rectangle(275,110,200,100));
        this.gameScreen = gameScreen;
    }

    @Override
    protected void function() {
        gameScreen.logic.clearLayer();
    }
}
