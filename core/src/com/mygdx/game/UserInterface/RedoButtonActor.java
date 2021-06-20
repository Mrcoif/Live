package com.mygdx.game.UserInterface;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;

import static com.mygdx.game.Live.SCREEN_WIDTH;

public class RedoButtonActor extends BaseButtonActor {

    private GameScreen gameScreen;

    public RedoButtonActor(GameScreen gameScreen) {
        super(new Vector2(0,215) , "->", gameScreen.live.arrowFont);
        this.gameScreen = gameScreen;
        setWidth(100);
        setX(getWidth() + 5);
        setHeight(gameScreen.live.font.getLineHeight());
    }

    @Override
    protected void function() {
        gameScreen.logic.generateNewLayer();
    }
}
