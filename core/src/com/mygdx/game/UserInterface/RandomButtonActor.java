package com.mygdx.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameScreen;

public class RandomButtonActor extends BaseButtonActor {

    private GameScreen gameScreen;
    private BaseButtonActor plus;
    private BaseButtonActor minus;
    private int chance = 5;
    private Texture black;
    private Texture gradient;
    private float gradientShift = chance;
    private int chanceRange = 100;

    public RandomButtonActor(GameScreen gameScreen) {
        super("buttons/random.png", new Rectangle(275, 5, 200, 100));
        this.gameScreen = gameScreen;
        speed = 30;
        black = new Texture(Gdx.files.internal("floor/black.png"));
        gradient = new Texture(Gdx.files.internal("buttons/greenRed.png"));
        plus = new BaseButtonActor("buttons/plus.png",  new Rectangle(220, 50, 50, 50));
        plus.speed = 5;
        minus = new BaseButtonActor("buttons/minus.png", new Rectangle(220, 15, 50, 20));
        minus.speed = 5;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        plus.act(delta);
        minus.act(delta);
        if (plus.isTouched && chance > 1) {
            chance--;
        } else if (minus.isTouched && chance < chanceRange) {
            chance++;
        }
        gradientShift = chance;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(gradient, 270 - gradientShift, 5, chanceRange, 100);
        batch.draw(black, 0, 5, 270, 100);
        batch.draw(black, 275, 5, 300, 100);
        super.draw(batch, parentAlpha);
        plus.draw(batch, parentAlpha);
        minus.draw(batch, parentAlpha);
    }

    @Override
    protected void function() {
        gameScreen.logic.randomLayer(chance);
    }
}
