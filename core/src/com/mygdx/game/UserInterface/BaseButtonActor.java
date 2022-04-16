package com.mygdx.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameScreen;

import static com.mygdx.game.Live.SCREEN_WIDTH;
import static com.mygdx.game.Live.touchPos;

import java.net.URISyntaxException;

public class BaseButtonActor extends Actor {

    protected Texture texture;
    public boolean isTouched = false;
    public int speed = 20;

    private String name;
    private int time = 0;
    private BitmapFont font;

    public BaseButtonActor(Vector2 cords ,  String name, BitmapFont font) {
        this.font = font;
        this.name = name;
        setBounds(cords.x, cords.y, font.getXHeight() * (name.length() + 1), font.getLineHeight());
        texture = new Texture(Gdx.files.internal("buttons/grey_button03.png"));
    }

    @Override
    public void act(float delta) {
        isTouched = false;
        if(time<speed) time++;
        if(time >= speed && Gdx.input.isTouched() && touchPos.x > getX() && touchPos.y > getY() && touchPos.x < getX()+getWidth() && touchPos.y < getY() + getHeight()){
            isTouched = true;
            time = 0;
        }
        if(isTouched) {
            try {
                function();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            isTouched = false;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, name, getX() + 7, getY() + (getHeight()/6*5));
    }

    protected void function() throws URISyntaxException {

    }

    public String getActorName(){
        return name;
    }
}
