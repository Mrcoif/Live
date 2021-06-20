package com.mygdx.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameScreen;

public class SizeChangerActor extends Actor {
    private GameScreen gameScreen;

    private Texture sizeWord;

    private int size;
    private float gradientShift = size;
    private int sizeRange = 200;

    public SizeChangerActor(GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        size = gameScreen.logic.floorLength;

        sizeWord = new Texture(Gdx.files.internal("buttons/size.png"));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
//        if (/*minus.isTouched && */size < sizeRange) {
//            size++;
//            gameScreen.logic.setFloorLength(gameScreen.logic.floorLength+1);
//        } else if (/*plus.isTouched && */size >2) {
//            size--;
//            gameScreen.logic.setFloorLength(gameScreen.logic.floorLength-1);
//        }
//        gradientShift = size;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(sizeWord,60 , 110, 150, 100);
    }
}
