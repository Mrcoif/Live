package com.mygdx.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.GameScreen;

public class UndoButtonActor extends BaseButtonActor{

    private GameScreen gameScreen;
    private BaseButtonActor plus;
    private BaseButtonActor minus;

    private Texture black;
    private Texture gradient;
    private float gradientShift = 0;
    private int speedRange = 30;

    public UndoButtonActor(GameScreen gameScreen) {
        super("buttons/undo.png",  new Rectangle(275,215,100,100));
        this.gameScreen = gameScreen;
        black = new Texture(Gdx.files.internal("floor/black.png"));
        gradient = new Texture(Gdx.files.internal("buttons/greenRed.png"));
        plus = new BaseButtonActor("buttons/plus.png", new Rectangle(220, 265, 50, 50));
        plus.speed = 5;
        minus = new BaseButtonActor("buttons/minus.png", new Rectangle(220, 230, 50, 20));
        minus.speed = 5;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        plus.act(delta);
        minus.act(delta);
        if (plus.isTouched && speed > 1) {
            speed--;
        } else if (minus.isTouched && speed < speedRange) {
            speed++;
        }
        gradientShift = speed;

        for (Actor actor : gameScreen.stage.getActors()) {
            if (actor instanceof RedoButtonActor) {
                ((RedoButtonActor) actor).speed = speed;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(gradient, 270 - gradientShift, 215, speedRange + 5, 100);
        batch.draw(black, 220, 215, 50, 100);
        batch.draw(black, 275,215,100,100);
        super.draw(batch, parentAlpha);
        plus.draw(batch, parentAlpha);
        minus.draw(batch, parentAlpha);
    }

    @Override
    protected void function() {
        if(gameScreen.logic.layerNum>0 && gameScreen.logic.layerNum-1 != gameScreen.logic.firstLayer)gameScreen.logic.layerNum--;
        else if (gameScreen.logic.fulled && gameScreen.logic.layerLength-1 != gameScreen.logic.firstLayer) gameScreen.logic.layerNum = gameScreen.logic.layerLength-1;
    }
}
