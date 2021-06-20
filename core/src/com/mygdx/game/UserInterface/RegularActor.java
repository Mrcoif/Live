package com.mygdx.game.UserInterface;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class RegularActor extends Actor {

    private BaseButtonActor plus;
    private BaseButtonActor minus;
    private int size;
    private int value = 0;

    public RegularActor(int size, Vector2 cords, BitmapFont font) {
        this.size = size;
        plus = new BaseButtonActor(cords, "+", font);
        minus = new BaseButtonActor(new Vector2(cords.x, cords.y + font.getLineHeight()/2), "-", font);
    }

    public void act(float delta) {
        plus.act(delta);
        minus.act(delta);

        if (minus.isTouched && value < size) {
            value++;
        } else if (plus.isTouched && value >2) {
            value--;
        }
    }

    public void draw(Batch batch, float parentAlpha) {
        plus.draw(batch, parentAlpha);
        minus.draw(batch, parentAlpha);
    }

    public int getValue(){
        return value;
    }
}
