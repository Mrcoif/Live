package com.mygdx.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.GameScreen;

import static com.mygdx.game.Live.SCREEN_WIDTH;

public class UndoButtonActor extends BaseButtonActor{

    private GameScreen gameScreen;
    private float gradientShift = 0;
    private int speedRange = 30;

    public UndoButtonActor(GameScreen gameScreen) {
        super(new Vector2(0, 215), "<-", gameScreen.live.arrowFont);
        this.gameScreen = gameScreen;
        setWidth(100);
        setHeight(gameScreen.live.font.getLineHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
//        if (/*plus.isTouched && */speed > 1) {
//            speed--;
//        } else if (/*minus.isTouched && */speed < speedRange) {
//            speed++;
//        }
//        gradientShift = speed;
//
//        for (Actor actor : gameScreen.stage.getActors()) {
//            if (actor instanceof RedoButtonActor) {
//                ((RedoButtonActor) actor).speed = speed;
//            }
//        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    protected void function() {
        if(gameScreen.logic.layerNum>0 && gameScreen.logic.layerNum-1 != gameScreen.logic.firstLayer)gameScreen.logic.layerNum--;
        else if (gameScreen.logic.fulled && gameScreen.logic.layerLength-1 != gameScreen.logic.firstLayer) gameScreen.logic.layerNum = gameScreen.logic.layerLength-1;
    }
}
