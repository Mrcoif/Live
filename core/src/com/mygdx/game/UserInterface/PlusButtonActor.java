package com.mygdx.game.UserInterface;

import static com.mygdx.game.Live.SCREEN_WIDTH;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameScreen;

public class PlusButtonActor extends BaseButtonActor{

    private GameScreen gameScreen;

    private int sizeRange = 50;

    public PlusButtonActor(GameScreen gameScreen) {
        super(new Vector2(SCREEN_WIDTH-60-5, 215), "+", gameScreen.live.font);
        this.gameScreen = gameScreen;


        speed = 5;
        setWidth(60);
    }

    @Override
    protected void function() {

        if (gameScreen.logic.size >3) {
            gameScreen.logic.size--;
            gameScreen.logic.setFloorLength(gameScreen.logic.floorLength - 1);
        }
        super.function();
    }
}
