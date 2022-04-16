package com.mygdx.game.UserInterface;

import static com.mygdx.game.Live.SCREEN_WIDTH;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameScreen;

public class MinusButtonActor extends BaseButtonActor{

    private GameScreen gameScreen;

    private int size = 0;
    private int sizeRange = 50;

    public MinusButtonActor(GameScreen gameScreen) {
        super(new Vector2(SCREEN_WIDTH-60*2-10, 215), "-", gameScreen.live.font);
        this.gameScreen = gameScreen;

        size = gameScreen.logic.floorLength;
        speed = 5;
        setWidth(60);
    }

    @Override
    protected void function() {
        if (gameScreen.logic.size < sizeRange) {
            gameScreen.logic.size++;
            gameScreen.logic.setFloorLength(gameScreen.logic.floorLength+1);
        }
        super.function();
    }
}
