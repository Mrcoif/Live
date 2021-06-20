package com.mygdx.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;

import static com.mygdx.game.Live.SCREEN_WIDTH;

public class RandomButtonActor extends BaseButtonActor {

    private GameScreen gameScreen;
    private int chance = 5;

    public RandomButtonActor(GameScreen gameScreen) {
        super(new Vector2(275, 5), "random", gameScreen.live.font);
        setX(SCREEN_WIDTH - getWidth());
        this.gameScreen = gameScreen;
        speed = 30;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    protected void function() {
        gameScreen.logic.randomLayer(chance);
    }
}
