package com.mygdx.game.UserInterface;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;

import static com.mygdx.game.Live.SCREEN_WIDTH;

public class ClearButtonActor extends BaseButtonActor{

    private GameScreen gameScreen;

    public ClearButtonActor(GameScreen gameScreen) {
        super(new Vector2(275,110), "clear", gameScreen.live.font);
        this.gameScreen = gameScreen;
        setX(SCREEN_WIDTH - getWidth());
    }

    @Override
    protected void function() {
        gameScreen.logic.clearLayer();
    }
}
