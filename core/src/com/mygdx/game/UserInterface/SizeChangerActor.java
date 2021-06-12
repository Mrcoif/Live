package com.mygdx.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameScreen;

public class SizeChangerActor extends Actor {
    private GameScreen gameScreen;

    private BaseButtonActor plus;
    private BaseButtonActor minus;

    private Texture black;
    private Texture gradient;
    private Texture sizeWord;

    private int size;
    private float gradientShift = size;
    private int sizeRange = 200;

    public SizeChangerActor(GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        size = gameScreen.logic.floorLength;

        black = new Texture(Gdx.files.internal("floor/black.png"));
        gradient = new Texture(Gdx.files.internal("buttons/greenRed.png"));
        sizeWord = new Texture(Gdx.files.internal("buttons/size.png"));

        plus = new BaseButtonActor("buttons/plus.png",  new Rectangle(5, 160, 50, 50));
        plus.speed = 5;
        minus = new BaseButtonActor("buttons/minus.png", new Rectangle(5, 130, 50, 20));
        minus.speed = 5;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        plus.act(delta);
        minus.act(delta);
        if (minus.isTouched && size < sizeRange) {
            size++;
            gameScreen.logic.setFloorLength(gameScreen.logic.floorLength+1);
        } else if (plus.isTouched && size >2) {
            size--;
            gameScreen.logic.setFloorLength(gameScreen.logic.floorLength-1);
        }
        gradientShift = size;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(gradient, 55 - gradientShift, 110, sizeRange + 5, 100);
        batch.draw(black, 0, 110, 55, 100);
        batch.draw(black, 60, 110, 420, 100);
        super.draw(batch, parentAlpha);
        plus.draw(batch, parentAlpha);
        minus.draw(batch, parentAlpha);
        batch.draw(sizeWord,60 , 110, 150, 100);
    }
}
